package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialRequest;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialResponse;
import com.cognis.vizion.api.repository.ObraMaterialRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraMaterialService extends BaseService<ObraMaterial, ObraMaterialRequest, ObraMaterialResponse, Integer> {
    private final ObraMaterialRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraMaterial, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<ObraMaterial> getEntityClass() { return ObraMaterial.class; }
    @Override protected Class<ObraMaterialResponse> getResponseClass() { return ObraMaterialResponse.class; }
}