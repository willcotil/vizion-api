package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraArquivos.dto.ObraArquivosRequest;
import com.cognis.vizion.api.core.obra.obraArquivos.dto.ObraArquivosResponse;
import com.cognis.vizion.api.service.FasesObraService;
import com.cognis.vizion.api.service.ObraArquivosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ObraArquivos")
public class ObraArquivosController extends GenericController<ObraArquivosRequest, ObraArquivosResponse, Integer> {

    public ObraArquivosController(ObraArquivosService obraArquivosService){
        super(obraArquivosService);
    }
}
