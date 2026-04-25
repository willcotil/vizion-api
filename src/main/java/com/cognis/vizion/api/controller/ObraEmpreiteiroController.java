package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import com.cognis.vizion.api.service.ObraEmpreiteiroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obra-empreiteiro")
public class ObraEmpreiteiroController extends GenericController<ObraEmpreiteiroRequest, ObraEmpreiteiroResponse, Integer> {

    public ObraEmpreiteiroController(ObraEmpreiteiroService obraEmpreiteiroService){
        super(obraEmpreiteiroService);
    }
}
