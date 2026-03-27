package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.cliente.ClienteResponse;
import com.cognis.buildup_api.core.empreiteiro.Empreiteiro;
import com.cognis.buildup_api.core.empreiteiro.EmpreiteiroRequest;
import com.cognis.buildup_api.core.empreiteiro.EmpreiteiroResponse;
import com.cognis.buildup_api.repository.EmpreiteiroRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpreiteiroService extends BaseService<Empreiteiro, EmpreiteiroRequest, EmpreiteiroResponse, Integer> {

    private final EmpreiteiroRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Empreiteiro, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteiro> getEntityClass() { return Empreiteiro.class; }
    @Override protected Class<EmpreiteiroResponse> getResponseClass() { return EmpreiteiroResponse.class; }
}
