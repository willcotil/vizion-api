package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.service.FasesObraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fasesObra")
public class FasesObraController extends GenericController<FasesObraRequest, FasesObraResponse, Integer>{

    public FasesObraController(FasesObraService fasesObraService){
        super(fasesObraService);
    }
}
