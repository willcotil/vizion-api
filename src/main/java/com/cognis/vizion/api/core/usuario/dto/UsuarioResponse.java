package com.cognis.vizion.api.core.usuario.dto;

import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;

public record UsuarioResponse (
        Integer id,
        String email,
        UsuarioStatus status,
        UsuarioRole role,
        String tenant_id
){
    public UsuarioResponse(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getStatus(),
                usuario.getRole(),
                usuario.getTenant_id()
        );
    }
}