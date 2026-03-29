package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.core.usuario.UsuarioResponse;
import com.cognis.buildup_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<UsuarioRequest, UsuarioResponse, Integer>{
    public UsuarioController(UsuarioService service){
        super(service);
    }
}
