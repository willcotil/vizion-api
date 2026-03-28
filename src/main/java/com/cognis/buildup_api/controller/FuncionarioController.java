package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.funcionario.Funcionario;
import com.cognis.buildup_api.core.funcionario.FuncionarioRequest;
import com.cognis.buildup_api.core.funcionario.FuncionarioResponse;
import com.cognis.buildup_api.service.FuncionarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController extends GenericController<FuncionarioRequest, FuncionarioResponse, Integer> {
    public FuncionarioController(FuncionarioService service){super(service);}
}
