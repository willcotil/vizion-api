package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.repository.FasesObraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FasesObraService extends BaseService<FasesObra, FasesObraRequest, FasesObraResponse, Integer> {
    private final FasesObraRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<FasesObra, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<FasesObra> getEntityClass() { return FasesObra.class; }
    @Override protected Class<FasesObraResponse> getResponseClass() { return FasesObraResponse.class; }
}
