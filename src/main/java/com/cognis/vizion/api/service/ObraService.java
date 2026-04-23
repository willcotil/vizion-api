package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.core.obra.state.ObraAcao;
import com.cognis.vizion.api.facade.ObraFacade;
import com.cognis.vizion.api.repository.ObraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraService extends BaseService<Obra, ObraRequest, ObraResponse, Integer> {
    private final ObraRepo repo;
    private final ModelMapper mapper;
    private final ObraFacade obraFacade;

    @Override protected JpaRepository<Obra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Obra> getEntityClass() { return Obra.class; }
    @Override protected Class<ObraResponse> getResponseClass() { return ObraResponse.class; }

    public ObraResponse transicionarStatus(Integer id, ObraStatusTransitionRequest request) {
        Obra obra = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra nao encontrada: " + id));

        ObraAcao acao = ObraAcao.from(request.acao());
        obraFacade.transicionarStatus(obra, acao);

        return mapper.map(repo.save(obra), ObraResponse.class);
    }
}
