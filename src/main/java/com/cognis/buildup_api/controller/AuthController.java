package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.core.usuario.UsuarioRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/me")
    public String me(@RequestBody UsuarioRequest req){
        if(req.getRole().equals(UsuarioRole.CLIENTE)){
            return "Olá Cliente!";
        } else if (req.getRole().equals(UsuarioRole.EMPREITEIRO)){
            return "Olá Empreiteiro!!";
        } else return "";
    }

}
