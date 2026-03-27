package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.obra.ObraRequest;
import com.cognis.buildup_api.core.obra.ObraResponse;
import com.cognis.buildup_api.service.ObraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obra")
public class ObraController extends GenericController<ObraRequest, ObraResponse, Integer>{

    public ObraController(ObraService obraService){
        super(obraService);
    }
}
