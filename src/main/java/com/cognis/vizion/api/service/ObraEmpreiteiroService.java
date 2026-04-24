package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import com.cognis.vizion.api.mapper.ObraEmpreiteiroMapper;
import com.cognis.vizion.api.repository.ObraEmpreiteiroRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraEmpreiteiroService extends BaseService<ObraEmpreiteiro, ObraEmpreiteiroRequest, ObraEmpreiteiroResponse, Integer> {

    private final ObraEmpreiteiroRepo repo;
    private final ObraEmpreiteiroMapper mapper;

    @Override protected JpaRepository<ObraEmpreiteiro, Integer> getRepo() { return repo; }
    @Override protected ObraEmpreiteiroMapper getMapper() { return mapper; }
    @Override protected Class<ObraEmpreiteiro> getEntityClass() { return ObraEmpreiteiro.class; }
    @Override protected Class<ObraEmpreiteiroResponse> getResponseClass() { return ObraEmpreiteiroResponse.class; }
}
