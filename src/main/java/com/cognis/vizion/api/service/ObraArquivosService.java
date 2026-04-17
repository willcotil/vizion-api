package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraArquivos.ObraArquivos;
import com.cognis.vizion.api.core.obra.obraArquivos.dto.ObraArquivosRequest;
import com.cognis.vizion.api.core.obra.obraArquivos.dto.ObraArquivosResponse;
import com.cognis.vizion.api.repository.ObraArquivosRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraArquivosService extends BaseService<ObraArquivos, ObraArquivosRequest, ObraArquivosResponse, Integer> {

    private final ObraArquivosRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraArquivos, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<ObraArquivos> getEntityClass() { return ObraArquivos.class; }
    @Override protected Class<ObraArquivosResponse> getResponseClass() { return ObraArquivosResponse.class; }
}
