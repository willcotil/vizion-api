package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.cliente.ClienteRequest;
import com.cognis.buildup_api.core.cliente.ClienteResponse;
import com.cognis.buildup_api.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClienteService extends BaseService<Cliente, ClienteRequest, ClienteResponse, Integer> {

    private final ClienteRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Cliente, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Cliente> getEntityClass() { return Cliente.class; }
    @Override protected Class<ClienteResponse> getResponseClass() { return ClienteResponse.class; }

    @Override
    public ClienteResponse atualizar(ClienteRequest request, Integer id) {
        if (!repo.existsById(id)) throw new RuntimeException("Cliente não encontrado");
        Cliente cliente = mapper.map(request, Cliente.class);
        cliente.setId(id);
        return mapper.map(repo.save(cliente), ClienteResponse.class);
    }
}
