package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import com.cognis.buildup_api.core.empreiteira.dto.EmpreiteiraRequest;
import com.cognis.buildup_api.core.empreiteira.dto.EmpreiteraResponse;
import com.cognis.buildup_api.repository.EmpreiteiraRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpreiteiraService extends BaseService<Empreiteira, EmpreiteiraRequest, EmpreiteraResponse, Integer> {
    private final EmpreiteiraRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Empreiteira, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteira> getEntityClass() { return Empreiteira.class; }
    @Override protected Class<EmpreiteraResponse> getResponseClass() { return EmpreiteraResponse.class; }
}
