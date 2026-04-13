package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.dto.EstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.EstoqueResponse;
import com.cognis.vizion.api.repository.EstoqueRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueService extends BaseService<Estoque, EstoqueRequest, EstoqueResponse, Integer> {

    private final EstoqueRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Estoque, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Estoque> getEntityClass() { return Estoque.class; }
    @Override protected Class<EstoqueResponse> getResponseClass() { return EstoqueResponse.class; }
}
