package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.TipoMovimentacao;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import com.cognis.vizion.api.infra.exception.ValidationException;
import com.cognis.vizion.api.repository.EstoqueRepo;
import com.cognis.vizion.api.repository.MovimentacaoEstoqueRepo;
import com.cognis.vizion.api.repository.ObraMaterialRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FasesObraEstoqueSyncServiceTest {

    @Mock
    private ObraMaterialRepo obraMaterialRepo;

    @Mock
    private EstoqueRepo estoqueRepo;

    @Mock
    private MovimentacaoEstoqueRepo movimentacaoEstoqueRepo;

    @InjectMocks
    private FasesObraEstoqueSyncService service;

    @Test
    void deveConsumirEstoqueAoIniciarFase() {
        FasesObra fase = new FasesObra();
        fase.setId(10);

        Material material = new Material();
        material.setId(7);

        ObraMaterial obraMaterial = new ObraMaterial();
        obraMaterial.setFases_obra(fase);
        obraMaterial.setMaterial(material);
        obraMaterial.setQuantidade(new BigDecimal("4.5"));
        obraMaterial.setValor_material(new BigDecimal("12.00"));

        Estoque estoque = new Estoque();
        estoque.setId(99);
        estoque.setMaterial(material);
        estoque.setQuantidade_atual(new BigDecimal("10.0"));

        when(obraMaterialRepo.findByFaseId(10)).thenReturn(List.of(obraMaterial));
        when(estoqueRepo.findFirstByMaterial_IdAndAtivoTrue(7)).thenReturn(Optional.of(estoque));
        when(estoqueRepo.save(any(Estoque.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(movimentacaoEstoqueRepo.save(any(MovimentacaoEstoque.class))).thenAnswer(invocation -> invocation.getArgument(0));

        service.registrarConsumoInicial(fase);

        ArgumentCaptor<Estoque> estoqueCaptor = ArgumentCaptor.forClass(Estoque.class);
        verify(estoqueRepo).save(estoqueCaptor.capture());
        assertEquals(new BigDecimal("5.5"), estoqueCaptor.getValue().getQuantidade_atual());

        ArgumentCaptor<MovimentacaoEstoque> movimentacaoCaptor = ArgumentCaptor.forClass(MovimentacaoEstoque.class);
        verify(movimentacaoEstoqueRepo).save(movimentacaoCaptor.capture());

        MovimentacaoEstoque movimentacao = movimentacaoCaptor.getValue();
        assertEquals(TipoMovimentacao.SAIDA, movimentacao.getTipo_movimentacao());
        assertEquals(new BigDecimal("4.5"), movimentacao.getQuantidade());
        assertEquals("FASE-10", movimentacao.getReferencia());
        assertEquals(estoque, movimentacao.getEstoque());
    }

    @Test
    void deveFalharQuandoEstoqueForInsuficiente() {
        FasesObra fase = new FasesObra();
        fase.setId(11);

        Material material = new Material();
        material.setId(8);

        ObraMaterial obraMaterial = new ObraMaterial();
        obraMaterial.setFases_obra(fase);
        obraMaterial.setMaterial(material);
        obraMaterial.setQuantidade(new BigDecimal("12"));
        obraMaterial.setValor_material(new BigDecimal("1.00"));

        Estoque estoque = new Estoque();
        estoque.setMaterial(material);
        estoque.setQuantidade_atual(new BigDecimal("3"));

        when(obraMaterialRepo.findByFaseId(11)).thenReturn(List.of(obraMaterial));
        when(estoqueRepo.findFirstByMaterial_IdAndAtivoTrue(8)).thenReturn(Optional.of(estoque));

        ValidationException exception = assertThrows(ValidationException.class,
                () -> service.registrarConsumoInicial(fase));

        assertEquals("Estoque insuficiente para o material 8", exception.getMessage());
        verify(estoqueRepo, never()).save(any());
        verify(movimentacaoEstoqueRepo, never()).save(any());
    }
}
