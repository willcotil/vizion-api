package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraAlocacao.ObraAlocacaoEquipe;
import com.cognis.vizion.api.core.obra.obraAlocacao.dto.AlocacaoObraRequest;
import com.cognis.vizion.api.core.obra.obraAlocacao.dto.AlocacaoObraResponse;
import com.cognis.vizion.api.repository.ObraAlocacaoRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlocacaoObraEquipeService extends BaseService<ObraAlocacaoEquipe, AlocacaoObraRequest, AlocacaoObraResponse, Integer> {

    private final ObraAlocacaoRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraAlocacaoEquipe, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<ObraAlocacaoEquipe> getEntityClass() { return ObraAlocacaoEquipe.class; }
    @Override protected Class<AlocacaoObraResponse> getResponseClass() { return AlocacaoObraResponse.class; }
}
