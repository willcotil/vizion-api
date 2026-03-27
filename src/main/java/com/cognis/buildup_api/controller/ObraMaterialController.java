package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.obra.fases_obra.obra_material.ObraMaterialRequest;
import com.cognis.buildup_api.core.obra.fases_obra.obra_material.ObraMaterialResponse;
import com.cognis.buildup_api.service.ObraMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obraMaterial")
public class ObraMaterialController extends GenericController<ObraMaterialRequest, ObraMaterialResponse, Integer>{
    public ObraMaterialController(ObraMaterialService obraMaterialService){
        super(obraMaterialService);
    }
}
