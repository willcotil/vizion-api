package com.cognis.vizion.api.service;


import com.cognis.vizion.api.core.obra.obraPropietarios.ObraProprietarios;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosRequest;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosResponse;
import com.cognis.vizion.api.repository.ObraProprietariosRepo;
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