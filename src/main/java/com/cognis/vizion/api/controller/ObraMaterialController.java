package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialRequest;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialResponse;
import com.cognis.vizion.api.service.ObraMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obraMaterial")
public class ObraMaterialController extends GenericController<ObraMaterialRequest, ObraMaterialResponse, Integer>{
    public ObraMaterialController(ObraMaterialService obraMaterialService){
        super(obraMaterialService);
    }
}
