package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteiraRequest;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteraResponse;
import com.cognis.vizion.api.mapper.EmpreiteiraMapper;
import com.cognis.vizion.api.repository.EmpreiteiraRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpreiteiraService extends BaseService<Empreiteira, EmpreiteiraRequest, EmpreiteraResponse, Integer> {
    private final EmpreiteiraRepo repo;
    private final EmpreiteiraMapper mapper;

    @Override protected JpaRepository<Empreiteira, Integer> getRepo() { return repo; }
    @Override protected EmpreiteiraMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteira> getEntityClass() { return Empreiteira.class; }
    @Override protected Class<EmpreiteraResponse> getResponseClass() { return EmpreiteraResponse.class; }
}
