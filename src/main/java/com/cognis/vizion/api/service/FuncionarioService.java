package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioRequest;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioResponse;
import com.cognis.vizion.api.mapper.FuncionarioMapper;
import com.cognis.vizion.api.repository.FuncionarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService extends BaseService<Funcionario, FuncionarioRequest, FuncionarioResponse, Integer>{
    private final FuncionarioRepo repo;
    private final FuncionarioMapper mapper;

    @Override protected JpaRepository<Funcionario, Integer> getRepo() { return repo; }
    @Override protected FuncionarioMapper getMapper() { return mapper; }
    @Override protected Class<Funcionario> getEntityClass() { return Funcionario.class; }
    @Override protected Class<FuncionarioResponse> getResponseClass() { return FuncionarioResponse.class; }
}
