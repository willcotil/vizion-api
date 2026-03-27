package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.cliente.ClienteResponse;
import com.cognis.buildup_api.core.funcionario.Funcionario;
import com.cognis.buildup_api.core.funcionario.FuncionarioRequest;
import com.cognis.buildup_api.core.funcionario.FuncionarioResponse;
import com.cognis.buildup_api.repository.ClienteRepo;
import com.cognis.buildup_api.repository.FuncionarioRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService extends BaseService<Funcionario, FuncionarioRequest, FuncionarioResponse, Integer>{
    private final FuncionarioRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<Funcionario, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Funcionario> getEntityClass() { return Funcionario.class; }
    @Override protected Class<FuncionarioResponse> getResponseClass() { return FuncionarioResponse.class; }
}
