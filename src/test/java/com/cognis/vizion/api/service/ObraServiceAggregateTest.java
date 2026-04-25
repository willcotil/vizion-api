package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraAggregateRequest;
import com.cognis.vizion.api.core.obra.dto.ObraDetailResponse;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraItemRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.TipoDocumento;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosItemRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.TipoFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroItemRequest;
import com.cognis.vizion.api.facade.ObraFacade;
import com.cognis.vizion.api.repository.EnderecoRepo;
import com.cognis.vizion.api.repository.FasesObraRepo;
import com.cognis.vizion.api.repository.MaterialRepo;
import com.cognis.vizion.api.repository.ObraFinanceiroRepo;
import com.cognis.vizion.api.repository.ObraRepo;
import com.cognis.vizion.api.repository.ObrasDocumentosRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cognis.vizion.api.mapper.ObraMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObraServiceAggregateTest {

    @Mock
    private ObraRepo repo;

    @Mock
    @SuppressWarnings("unused")
    private EnderecoRepo enderecoRepo;

    @Mock
    private MaterialRepo materialRepo;

    @Mock
    private FasesObraRepo fasesObraRepo;

    @Mock
    private ObraFinanceiroRepo obraFinanceiroRepo;

    @Mock
    private ObrasDocumentosRepo obrasDocumentosRepo;

    @Mock
    @SuppressWarnings("unused")
    private ObraMapper mapper;

    @Mock
    @SuppressWarnings("unused")
    private ObraFacade obraFacade;

    @InjectMocks
    private ObraService service;

    @Test
    void deveSalvarObraAggregadaComFilhos() {
        when(mapper.toResponse(any(Obra.class))).thenAnswer(invocation -> new ObraResponse(invocation.getArgument(0)));

        Date dataInicio = new Date(1_700_000_000_000L);
        Date dataEntrega = new Date(1_700_086_400_000L);

        Material material = new Material();
        material.setId(7);

        when(repo.save(any(Obra.class))).thenAnswer(invocation -> {
            Obra obra = invocation.getArgument(0);
            obra.setId(1);
            int sequence = 1;
            if (obra.getFases() != null) {
                for (FasesObra fase : obra.getFases()) {
                    fase.setId(sequence++);
                }
            }
            return obra;
        });
        when(materialRepo.findById(7)).thenReturn(Optional.of(material));

        ObraAggregateRequest request = new ObraAggregateRequest(
                "TENANT-1",
                "Obra piloto",
                new EnderecoRequest("Rua A", "100", "Apto 1", "Centro", "São Paulo", "SP", "01000-000"),
                dataInicio,
                dataEntrega,
                new BigDecimal("125000.00"),
                "PLANEJADA",
                List.of(new FasesObraItemRequest(
                        null,
                        "Projeto",
                        "Fase inicial",
                        dataInicio,
                        null,
                        null,
                        null,
                        new BigDecimal("5000.00"),
                        new BigDecimal("0.00"),
                        "PLANEJADA",
                        1
                )),
                List.of(new ObraFinanceiroItemRequest(
                        null,
                        "Compra de cimento",
                        TipoFinanceiro.DESPESA,
                        new BigDecimal("2500.00"),
                        null,
                        LocalDate.of(2026, 4, 23),
                        false,
                        7
                )),
                List.of(new ObrasDocumentosItemRequest(
                        null,
                        TipoDocumento.ARQUIVO,
                        "contrato.pdf",
                        "https://exemplo.com/contrato.pdf",
                        "Contrato inicial"
                ))
        );

        ObraDetailResponse response = service.salvarAggregate(request);

        ArgumentCaptor<Obra> obraCaptor = ArgumentCaptor.forClass(Obra.class);
        verify(repo).save(obraCaptor.capture());

        Obra saved = obraCaptor.getValue();
        assertEquals("TENANT-1", saved.getTenant_id());
        assertEquals("Obra piloto", saved.getNome_projeto());
        assertEquals(dataInicio, saved.getData_inicio());
        assertEquals(dataEntrega, saved.getData_previsao_entrega());
        assertEquals(new BigDecimal("125000.00"), saved.getValor_total_estimado());
        assertEquals("PLANEJADA", saved.getStatus());

        assertNotNull(saved.getEndereco());
        assertEquals("Rua A", saved.getEndereco().getLogradouro());
        assertEquals("SP", saved.getEndereco().getEstado());

        assertEquals(1, saved.getFases().size());
        assertSame(saved, saved.getFases().getFirst().getObra());
        assertEquals("Projeto", saved.getFases().getFirst().getNome_fase());

        assertEquals(1, saved.getFinanceiro().size());
        assertSame(saved, saved.getFinanceiro().getFirst().getObra());
        assertSame(material, saved.getFinanceiro().getFirst().getMaterial());

        assertEquals(1, saved.getDocumentos().size());
        assertSame(saved, saved.getDocumentos().getFirst().getObra());
        assertEquals("TENANT-1", saved.getDocumentos().getFirst().getTenant_id());

        assertEquals("Obra piloto", response.nome_projeto());
        assertEquals(1, response.fases().size());
        assertEquals(1, response.financeiro().size());
        assertEquals(1, response.documentos().size());
    }

    @Test
    void deveAtualizarObraAggregadaReutilizandoEntidadesExistentes() {
        when(mapper.toResponse(any(Obra.class))).thenAnswer(invocation -> new ObraResponse(invocation.getArgument(0)));

        Date dataInicio = new Date(1_700_000_000_000L);
        Date dataEntrega = new Date(1_700_086_400_000L);

        Endereco endereco = new Endereco();
        endereco.setId(9);

        FasesObra fase = new FasesObra();
        fase.setId(11);

        Material material = new Material();
        material.setId(7);

        ObraFinanceiro financeiro = new ObraFinanceiro();
        financeiro.setId(22);

        ObrasDocumentos documento = new ObrasDocumentos();
        documento.setId(33);

        Obra existing = new Obra();
        existing.setId(99);
        existing.setEndereco(endereco);
        existing.setFases(List.of(fase));
        existing.setFinanceiro(List.of(financeiro));
        existing.setDocumentos(List.of(documento));

        when(repo.existsById(99)).thenReturn(true);
        when(repo.findById(99)).thenReturn(Optional.of(existing));
        when(repo.save(any(Obra.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(fasesObraRepo.findById(11)).thenReturn(Optional.of(fase));
        when(obraFinanceiroRepo.findById(22)).thenReturn(Optional.of(financeiro));
        when(obrasDocumentosRepo.findById(33)).thenReturn(Optional.of(documento));
        when(materialRepo.findById(7)).thenReturn(Optional.of(material));

        ObraAggregateRequest request = new ObraAggregateRequest(
                "TENANT-2",
                "Obra atualizada",
                new EnderecoRequest("Rua B", "200", null, "Bairro Novo", "Campinas", "SP", "13000-000"),
                dataInicio,
                dataEntrega,
                new BigDecimal("150000.00"),
                "EM_ANDAMENTO",
                List.of(new FasesObraItemRequest(
                        11,
                        "Execução",
                        "Fase atualizada",
                        dataInicio,
                        null,
                        null,
                        null,
                        new BigDecimal("7000.00"),
                        new BigDecimal("1000.00"),
                        "EM_ANDAMENTO",
                        2
                )),
                List.of(new ObraFinanceiroItemRequest(
                        22,
                        "Aluguel de equipamento",
                        TipoFinanceiro.DESPESA,
                        new BigDecimal("4200.00"),
                        java.time.LocalDate.of(2026, 4, 24),
                        java.time.LocalDate.of(2026, 4, 25),
                        true,
                        7
                )),
                List.of(new ObrasDocumentosItemRequest(
                        33,
                        TipoDocumento.PLANTA,
                        "contrato-atualizado.pdf",
                        "https://exemplo.com/contrato-atualizado.pdf",
                        "Contrato revisado"
                ))
        );

        ObraDetailResponse response = service.atualizarAggregate(99, request);

        ArgumentCaptor<Obra> obraCaptor = ArgumentCaptor.forClass(Obra.class);
        verify(repo).save(obraCaptor.capture());

        Obra saved = obraCaptor.getValue();
        assertEquals(99, saved.getId());
        assertEquals("TENANT-2", saved.getTenant_id());
        assertEquals("Rua B", saved.getEndereco().getLogradouro());
        assertEquals("Campinas", saved.getEndereco().getCidade());
        assertEquals("Execução", saved.getFases().getFirst().getNome_fase());
        assertSame(saved, saved.getFases().getFirst().getObra());
        assertEquals("Aluguel de equipamento", saved.getFinanceiro().getFirst().getDescricao());
        assertSame(material, saved.getFinanceiro().getFirst().getMaterial());
        assertEquals("contrato-atualizado.pdf", saved.getDocumentos().getFirst().getNome_arquivo());
        assertSame(saved, saved.getDocumentos().getFirst().getObra());

        assertEquals("Obra atualizada", response.nome_projeto());
        verify(fasesObraRepo).findById(11);
        verify(obraFinanceiroRepo).findById(22);
        verify(obrasDocumentosRepo).findById(33);
    }
}




