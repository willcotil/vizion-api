package com.cognis.vizion.api.core.usuario.dto;


import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;

public record UsuarioRequest (
        String email,
        String senha,
        UsuarioStatus status,
        UsuarioRole role
){

}