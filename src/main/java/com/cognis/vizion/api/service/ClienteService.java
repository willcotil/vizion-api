package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.cliente.dto.ClienteRequest;
import com.cognis.vizion.api.core.cliente.dto.ClienteResponse;
import com.cognis.vizion.api.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService extends BaseService<Cliente, ClienteRequest, ClienteResponse, Integer> {

    private final ClienteRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Cliente, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Cliente> getEntityClass() { return Cliente.class; }
    @Override protected Class<ClienteResponse> getResponseClass() { return ClienteResponse.class; }
}
