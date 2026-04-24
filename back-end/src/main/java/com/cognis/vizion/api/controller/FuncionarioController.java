package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.funcionario.dto.FuncionarioRequest;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioResponse;
import com.cognis.vizion.api.service.FuncionarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController extends GenericController<FuncionarioRequest, FuncionarioResponse, Integer> {
    public FuncionarioController(FuncionarioService service){super(service);}
}
