package com.cognis.vizion.api.core.usuario.dto;


import com.cognis.vizion.api.core.usuario.UsuarioRole;

public record UsuarioRequest (
        String email,
        String senha,
        String status,
        UsuarioRole role
){

}