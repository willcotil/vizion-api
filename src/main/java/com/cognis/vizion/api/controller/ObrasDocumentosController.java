package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosResponse;
import com.cognis.vizion.api.service.ObrasDocumentosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obrasDocumentos")
public class ObrasDocumentosController extends GenericController<ObrasDocumentosRequest, ObrasDocumentosResponse, Integer> {

    public ObrasDocumentosController(ObrasDocumentosService service) {
        super(service);
    }
}
