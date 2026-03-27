package com.cognis.buildup_api.service;


import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietarios;
import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietariosRequest;
import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietariosResponse;
import com.cognis.buildup_api.repository.ObraProprietariosRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraProprietariosService extends BaseService<ObraProprietarios, ObraProprietariosRequest, ObraProprietariosResponse, Integer> {
    private final ObraProprietariosRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraProprietarios, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<ObraProprietarios> getEntityClass() { return ObraProprietarios.class; }
    @Override protected Class<ObraProprietariosResponse> getResponseClass() { return ObraProprietariosResponse.class; }
}