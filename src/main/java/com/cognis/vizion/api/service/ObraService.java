package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraAggregateRequest;
import com.cognis.vizion.api.core.obra.dto.ObraDetailResponse;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraItemRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosItemRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroItemRequest;
import com.cognis.vizion.api.core.obra.state.ObraAcao;
import com.cognis.vizion.api.facade.ObraFacade;
import com.cognis.vizion.api.repository.EnderecoRepo;
import com.cognis.vizion.api.repository.FasesObraRepo;
import com.cognis.vizion.api.repository.MaterialRepo;
import com.cognis.vizion.api.repository.ObraFinanceiroRepo;
import com.cognis.vizion.api.repository.ObraRepo;
import com.cognis.vizion.api.repository.ObrasDocumentosRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService extends BaseService<Obra, ObraRequest, ObraResponse, Integer> {
    private final ObraRepo repo;
    private final EnderecoRepo enderecoRepo;
    private final MaterialRepo materialRepo;
    private final FasesObraRepo fasesObraRepo;
    private final ObraFinanceiroRepo obraFinanceiroRepo;
    private final ObrasDocumentosRepo obrasDocumentosRepo;
    private final ModelMapper mapper;
    private final ObraFacade obraFacade;

    @Override protected JpaRepository<Obra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Obra> getEntityClass() { return Obra.class; }
    @Override protected Class<ObraResponse> getResponseClass() { return ObraResponse.class; }

    @Override
    @Transactional
    public ObraResponse salvar(ObraRequest request) {
        return salvarOuAtualizar(request, null);
    }

    @Override
    @Transactional
    public ObraResponse atualizar(ObraRequest request, Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        return salvarOuAtualizar(request, id);
    }

    @Transactional
    public ObraResponse transicionarStatus(Integer id, ObraStatusTransitionRequest request) {
        Obra obra = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra nao encontrada: " + id));

        ObraAcao acao = ObraAcao.from(request.acao());
        obraFacade.transicionarStatus(obra, acao);

        return mapper.map(repo.save(obra), ObraResponse.class);
    }

    @Transactional
    public ObraDetailResponse salvarAggregate(ObraAggregateRequest request) {
        return salvarOuAtualizarAggregate(request, null);
    }

    @Transactional
    public ObraDetailResponse atualizarAggregate(Integer id, ObraAggregateRequest request) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        return salvarOuAtualizarAggregate(request, id);
    }

    private ObraResponse salvarOuAtualizar(ObraRequest request, Integer id) {
        Obra entity = id == null
                ? new Obra()
                : repo.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));

        entity.setNome_projeto(request.nome_projeto());
        entity.setData_inicio(request.data_inicio());
        entity.setData_previsao_entrega(request.data_previsao_entrega());
        entity.setValor_total_estimado(request.valor_total_estimado());
        entity.setStatus(request.status());
        entity.setTenant_id(request.tenant_id());

        if (request.id_endereco() != null) {
            Endereco endereco = enderecoRepo.findById(request.id_endereco())
                    .orElseThrow(() -> new RuntimeException("Endereco nao encontrado: " + request.id_endereco()));
            entity.setEndereco(endereco);
        }

        return new ObraResponse(repo.save(entity));
    }

    private ObraDetailResponse salvarOuAtualizarAggregate(ObraAggregateRequest request, Integer id) {
        Obra entity = id == null
                ? new Obra()
                : repo.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));

        entity.setTenant_id(request.tenant_id());
        entity.setNome_projeto(request.nome_projeto());
        entity.setData_inicio(request.data_inicio());
        entity.setData_previsao_entrega(request.data_previsao_entrega());
        entity.setValor_total_estimado(request.valor_total_estimado());
        entity.setStatus(request.status());
        entity.setEndereco(aplicarEndereco(entity.getEndereco(), request.endereco()));
        entity.setFases(mapearFases(entity, request.fases()));
        entity.setFinanceiro(mapearFinanceiro(entity, request.financeiro()));
        entity.setDocumentos(mapearDocumentos(entity, request.documentos()));

        return new ObraDetailResponse(repo.save(entity));
    }

    private Endereco aplicarEndereco(Endereco atual, EnderecoRequest request) {
        Endereco endereco = atual != null ? atual : new Endereco();
        endereco.setLogradouro(request.logradouro());
        endereco.setNumero(request.numero());
        endereco.setComplemento(request.complemento());
        endereco.setBairro(request.bairro());
        endereco.setCidade(request.cidade());
        endereco.setEstado(request.estado());
        endereco.setCep(request.cep());
        return endereco;
    }

    private List<FasesObra> mapearFases(Obra obra, List<FasesObraItemRequest> fases) {
        if (fases == null) {
            return new ArrayList<>();
        }

        List<FasesObra> entities = new ArrayList<>(fases.size());
        for (FasesObraItemRequest request : fases) {
            FasesObra fase = request.id() != null
                    ? fasesObraRepo.findById(request.id())
                    .orElseThrow(() -> new RuntimeException("Fase de obra não encontrada: " + request.id()))
                    : new FasesObra();

            fase.setObra(obra);
            fase.setNome_fase(request.nome_fase());
            fase.setDescricao(request.descricao());
            fase.setData_inicio_estimada(request.data_inicio_estimada());
            fase.setData_iniciada(request.data_iniciada());
            fase.setData_fim_estimada(request.data_fim_estimada());
            fase.setData_finalizada(request.data_finalizada());
            fase.setValor_estimado(request.valor_estimado());
            fase.setValor_pago(request.valor_pago());
            fase.setStatus(request.status());
            fase.setOrdem_exibicao(request.ordem_exibicao());
            entities.add(fase);
        }

        return entities;
    }

    private List<ObraFinanceiro> mapearFinanceiro(Obra obra, List<ObraFinanceiroItemRequest> financeiro) {
        if (financeiro == null) {
            return new ArrayList<>();
        }

        List<ObraFinanceiro> entities = new ArrayList<>(financeiro.size());
        for (ObraFinanceiroItemRequest request : financeiro) {
            ObraFinanceiro item = request.id() != null
                    ? obraFinanceiroRepo.findById(request.id())
                    .orElseThrow(() -> new RuntimeException("Lançamento financeiro não encontrado: " + request.id()))
                    : new ObraFinanceiro();

            item.setObra(obra);
            item.setDescricao(request.descricao());
            item.setTipo(request.tipo_financeiro());
            item.setValor(request.valor());
            item.setDataPagamento(request.dataPagamento());
            item.setDataEstimado(request.dataEstimado());
            item.setPago(request.pago());
            item.setMaterial(resolveMaterial(request.idMaterial()));
            entities.add(item);
        }

        return entities;
    }

    private List<ObrasDocumentos> mapearDocumentos(Obra obra, List<ObrasDocumentosItemRequest> documentos) {
        if (documentos == null) {
            return new ArrayList<>();
        }

        List<ObrasDocumentos> entities = new ArrayList<>(documentos.size());
        for (ObrasDocumentosItemRequest request : documentos) {
            ObrasDocumentos documento = request.id() != null
                    ? obrasDocumentosRepo.findById(request.id())
                    .orElseThrow(() -> new RuntimeException("Documento da obra não encontrado: " + request.id()))
                    : new ObrasDocumentos();

            documento.setObra(obra);
            documento.setTenant_id(obra.getTenant_id());
            documento.setTipo_documento(request.tipo_documento());
            documento.setNome_arquivo(request.nome_arquivo());
            documento.setUrl_arquivo(request.url_arquivo());
            documento.setDescricao_arquivo(request.descricao_arquivo());
            entities.add(documento);
        }

        return entities;
    }

    private Material resolveMaterial(Integer idMaterial) {
        if (idMaterial == null) {
            return null;
        }

        return materialRepo.findById(idMaterial)
                .orElseThrow(() -> new RuntimeException("Material não encontrado: " + idMaterial));
    }
}
