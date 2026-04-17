package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.obraPlanta.dto.ObraPlantaRequest;
import com.cognis.vizion.api.core.obra.obraPlanta.dto.ObraPlantaResponse;
import com.cognis.vizion.api.service.ObraPlantaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/obraPlanta")
public class ObraPlantaController extends GenericController<ObraPlantaRequest, ObraPlantaResponse, Integer>{
    public ObraPlantaController(ObraPlantaService obraPlantaService){super((obraPlantaService));}
}
