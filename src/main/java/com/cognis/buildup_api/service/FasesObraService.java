package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.obra.fases_obra.FasesObra;
import com.cognis.buildup_api.core.obra.fases_obra.FasesObraRequest;
import com.cognis.buildup_api.core.obra.fases_obra.FasesObraResponse;
import com.cognis.buildup_api.repository.FasesObraRepo;
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
