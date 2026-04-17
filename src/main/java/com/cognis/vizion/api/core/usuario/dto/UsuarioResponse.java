package com.cognis.vizion.api.core.usuario.dto;

import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioRole;

public record UsuarioResponse (
        Integer id,
        String email,
        String status,
        UsuarioRole role,
        String tenant_id
){
    public UsuarioResponse(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getEmail(),
                String.valueOf(usuario.getStatus()),
                usuario.getRole(),
                usuario.getTenant_id()
        );
    }
}