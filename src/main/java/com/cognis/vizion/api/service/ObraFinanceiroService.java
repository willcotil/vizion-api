package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroResponse;
import com.cognis.vizion.api.repository.ObraFinanceiroRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraFinanceiroService extends BaseService<ObraFinanceiro, ObraFinanceiroRequest, ObraFinanceiroResponse, Integer> {

    private final ObraFinanceiroRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraFinanceiro, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<ObraFinanceiro> getEntityClass() { return ObraFinanceiro.class; }
    @Override protected Class<ObraFinanceiroResponse> getResponseClass() { return ObraFinanceiroResponse.class; }
}