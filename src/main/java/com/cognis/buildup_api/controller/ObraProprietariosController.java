package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietariosRequest;
import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietariosResponse;
import com.cognis.buildup_api.service.ObraProprietariosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obraProprietarios")
public class ObraProprietariosController extends GenericController<ObraProprietariosRequest, ObraProprietariosResponse, Integer>{

    public ObraProprietariosController(ObraProprietariosService obraProprietariosService){
        super(obraProprietariosService);
    }
}
