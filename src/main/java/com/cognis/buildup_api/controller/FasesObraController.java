package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.buildup_api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.buildup_api.service.FasesObraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fasesObra")
public class FasesObraController extends GenericController<FasesObraRequest, FasesObraResponse, Integer>{

    public FasesObraController(FasesObraService fasesObraService){
        super(fasesObraService);
    }
}
