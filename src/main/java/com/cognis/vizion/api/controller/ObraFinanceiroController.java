package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroResponse;
import com.cognis.vizion.api.service.ObraFinanceiroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obra-financeiro")
public class ObraFinanceiroController extends GenericController<ObraFinanceiroRequest, ObraFinanceiroResponse, Integer> {

    public ObraFinanceiroController(ObraFinanceiroService service) {
        super(service);
    }
}