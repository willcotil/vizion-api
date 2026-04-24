package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosResponse;
import com.cognis.vizion.api.mapper.ObraFuncionariosMapper;
import com.cognis.vizion.api.repository.ObraFuncionariosRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraFuncionariosService extends BaseService<ObraFuncionarios, ObraFuncionariosRequest, ObraFuncionariosResponse, Integer> {

    private final ObraFuncionariosRepo repo;
    private final ObraFuncionariosMapper mapper;

    @Override protected JpaRepository<ObraFuncionarios, Integer> getRepo() { return repo; }
    @Override protected ObraFuncionariosMapper getMapper() { return mapper; }
    @Override protected Class<ObraFuncionarios> getEntityClass() { return ObraFuncionarios.class; }
    @Override protected Class<ObraFuncionariosResponse> getResponseClass() { return ObraFuncionariosResponse.class; }
}
