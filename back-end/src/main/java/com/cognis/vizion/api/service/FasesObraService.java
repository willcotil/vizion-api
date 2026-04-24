package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraStatusTransitionRequest;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraAcao;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraStatus;
import com.cognis.vizion.api.facade.FasesObraFacade;
import com.cognis.vizion.api.mapper.FasesObraMapper;
import com.cognis.vizion.api.repository.FasesObraRepo;
import com.cognis.vizion.api.repository.ObraRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FasesObraService extends BaseService<FasesObra, FasesObraRequest, FasesObraResponse, Integer> {
    private final FasesObraRepo repo;
    private final ObraRepo obraRepo;
    private final FasesObraMapper mapper;
    private final FasesObraFacade fasesObraFacade;
    private final FasesObraEstoqueSyncService estoqueSyncService;

    @Override protected JpaRepository<FasesObra, Integer> getRepo() { return repo; }
    @Override protected FasesObraMapper getMapper() { return mapper; }
    @Override protected Class<FasesObra> getEntityClass() { return FasesObra.class; }
    @Override protected Class<FasesObraResponse> getResponseClass() { return FasesObraResponse.class; }

    @Override
    @Transactional
    public FasesObraResponse salvar(FasesObraRequest request) {
        return salvarOuAtualizar(request, null);
    }

    @Override
    @Transactional
    public FasesObraResponse atualizar(FasesObraRequest request, Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        return salvarOuAtualizar(request, id);
    }

    @Transactional
    public FasesObraResponse transicionarStatus(Integer id, FasesObraStatusTransitionRequest request) {
        FasesObra fase = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Fase de obra nao encontrada: " + id));

        FasesObraAcao acao = FasesObraAcao.from(request.acao());
        fasesObraFacade.transicionarStatus(fase, acao);

        FasesObraResponse response = mapper.toResponse(repo.save(fase));

        if (FasesObraStatus.from(fase.getStatus()) == FasesObraStatus.EM_ANDAMENTO) {
            estoqueSyncService.registrarConsumoInicial(fase);
        }

        return response;
    }

    private FasesObraResponse salvarOuAtualizar(FasesObraRequest request, Integer id) {
        FasesObra entity = id == null
                ? new FasesObra()
                : repo.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));

        entity.setNome_fase(request.nome_fase());
        entity.setDescricao(request.descricao());
        entity.setData_inicio_estimada(request.data_inicio_estimada());
        entity.setData_iniciada(request.data_iniciada());
        entity.setData_fim_estimada(request.data_fim_estimada());
        entity.setData_finalizada(request.data_finalizada());
        entity.setValor_estimado(request.valor_estimado());
        entity.setValor_pago(request.valor_pago());
        entity.setStatus(request.status());
        entity.setOrdem_exibicao(request.ordem_exibicao());
        entity.setObra(resolveObra(request.id_obra()));

        return mapper.toResponse(repo.save(entity));
    }

    private Obra resolveObra(Integer idObra) {
        if (idObra == null) {
            throw new RuntimeException("id_obra é obrigatório");
        }

        return obraRepo.findById(idObra)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada: " + idObra));
    }
}
