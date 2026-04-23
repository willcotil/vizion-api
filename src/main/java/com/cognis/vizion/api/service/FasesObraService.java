package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraStatusTransitionRequest;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraAcao;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraStatus;
import com.cognis.vizion.api.facade.FasesObraFacade;
import com.cognis.vizion.api.repository.FasesObraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FasesObraService extends BaseService<FasesObra, FasesObraRequest, FasesObraResponse, Integer> {
    private final FasesObraRepo repo;
    private final ModelMapper mapper;
    private final FasesObraFacade fasesObraFacade;
    private final FasesObraEstoqueSyncService estoqueSyncService;

    @Override protected JpaRepository<FasesObra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<FasesObra> getEntityClass() { return FasesObra.class; }
    @Override protected Class<FasesObraResponse> getResponseClass() { return FasesObraResponse.class; }

    @Transactional
    public FasesObraResponse transicionarStatus(Integer id, FasesObraStatusTransitionRequest request) {
        FasesObra fase = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Fase de obra nao encontrada: " + id));

        FasesObraAcao acao = FasesObraAcao.from(request.acao());
        fasesObraFacade.transicionarStatus(fase, acao);

        FasesObraResponse response = mapper.map(repo.save(fase), FasesObraResponse.class);

        if (FasesObraStatus.from(fase.getStatus()) == FasesObraStatus.EM_ANDAMENTO) {
            estoqueSyncService.registrarConsumoInicial(fase);
        }

        return response;
    }
}
