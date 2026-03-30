package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.service.ObraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obra")
public class ObraController extends GenericController<ObraRequest, ObraResponse, Integer>{

    public ObraController(ObraService obraService){
        super(obraService);
    }
}
