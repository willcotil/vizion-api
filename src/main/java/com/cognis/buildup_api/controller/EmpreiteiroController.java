package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.buildup_api.service.EmpreiteiroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empreiteiro")
public class EmpreiteiroController extends GenericController<EmpreiteiroRequest, EmpreiteiroResponse, Integer> {
    public EmpreiteiroController(EmpreiteiroService service){
        super(service);
    }
}
