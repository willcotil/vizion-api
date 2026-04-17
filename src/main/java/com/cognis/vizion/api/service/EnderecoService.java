package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.endereco.dto.EnderecoResponse;
import com.cognis.vizion.api.repository.EnderecoRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService extends BaseService<Endereco, EnderecoRequest, EnderecoResponse, Integer>{
    private final EnderecoRepo repo;
    private final ModelMapper mapper;

    @Override
    protected JpaRepository<Endereco, Integer> getRepo() {
        return repo;
    }

    @Override
    protected ModelMapper getMapper() {
        return mapper;
    }

    @Override
    protected Class<Endereco> getEntityClass() {
        return Endereco.class;
    }

    @Override
    protected Class<EnderecoResponse> getResponseClass() {
        return EnderecoResponse.class;
    }
}
