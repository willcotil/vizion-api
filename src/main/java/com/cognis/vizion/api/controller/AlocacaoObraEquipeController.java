package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraAlocacao.dto.AlocacaoObraRequest;
import com.cognis.vizion.api.core.obra.obraAlocacao.dto.AlocacaoObraResponse;
import com.cognis.vizion.api.service.IGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obraAlocacaoEquipe")
public class AlocacaoObraEquipeController extends GenericController<AlocacaoObraRequest, AlocacaoObraResponse, Integer>{

    protected AlocacaoObraEquipeController(IGenericService<AlocacaoObraRequest, AlocacaoObraResponse, Integer> service) {
        super(service);
    }
}
