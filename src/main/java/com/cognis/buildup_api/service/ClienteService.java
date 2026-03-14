package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.cliente.ClienteRequest;
import com.cognis.buildup_api.core.cliente.ClienteResponse;
import com.cognis.buildup_api.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepo repo;
    private final ModelMapper mapper;

    public ClienteResponse salvar(ClienteRequest request){
        try{
            Cliente cliente = mapper.map(request, Cliente.class);
            return mapper.map(repo.save(cliente), ClienteResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao salvar cliente ", e);
        }
    }

}
