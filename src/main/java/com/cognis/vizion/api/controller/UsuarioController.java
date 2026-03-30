package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.usuario.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.UsuarioResponse;
import com.cognis.vizion.api.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<UsuarioRequest, UsuarioResponse, Integer>{
    public UsuarioController(UsuarioService service){
        super(service);
    }
}
