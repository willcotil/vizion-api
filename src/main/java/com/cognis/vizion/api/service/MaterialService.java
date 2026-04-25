package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.dto.MaterialRequest;
import com.cognis.vizion.api.core.estoque.dto.MaterialResponse;
import com.cognis.vizion.api.mapper.MaterialMapper;
import com.cognis.vizion.api.repository.MaterialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService extends BaseService<Material, MaterialRequest, MaterialResponse, Integer> {

    private final MaterialRepo repo;
    private final MaterialMapper mapper;

    @Override protected JpaRepository<Material, Integer> getRepo() { return repo; }
    @Override protected MaterialMapper getMapper() { return mapper; }
    @Override protected Class<Material> getEntityClass() { return Material.class; }
    @Override protected Class<MaterialResponse> getResponseClass() { return MaterialResponse.class; }
}
