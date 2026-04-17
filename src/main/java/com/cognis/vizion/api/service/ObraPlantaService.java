package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.obra.obraPlanta.ObraPlanta;
import com.cognis.vizion.api.core.obra.obraPlanta.dto.ObraPlantaRequest;
import com.cognis.vizion.api.core.obra.obraPlanta.dto.ObraPlantaResponse;
import com.cognis.vizion.api.repository.ObraPlantaRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraPlantaService extends BaseService<ObraPlanta, ObraPlantaRequest, ObraPlantaResponse, Integer>{
    private final ObraPlantaRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<ObraPlanta, Integer> getRepo() {return repo;}
    @Override protected ModelMapper getMapper() {return mapper;}
    @Override protected Class<ObraPlanta> getEntityClass() {return ObraPlanta.class;}
    @Override protected Class<ObraPlantaResponse> getResponseClass() {return ObraPlantaResponse.class;}
}
