package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.obra.Obra;
import com.cognis.buildup_api.core.obra.dto.ObraRequest;
import com.cognis.buildup_api.core.obra.dto.ObraResponse;
import com.cognis.buildup_api.repository.ObraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraService extends BaseService<Obra, ObraRequest, ObraResponse, Integer> {
    private final ObraRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Obra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Obra> getEntityClass() { return Obra.class; }
    @Override protected Class<ObraResponse> getResponseClass() { return ObraResponse.class; }
}
