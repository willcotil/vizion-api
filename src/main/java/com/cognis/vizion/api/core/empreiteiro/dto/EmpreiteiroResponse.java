package com.cognis.vizion.api.core.empreiteiro.dto;


import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;

public record EmpreiteiroResponse (
        String name,
        String documento,
        String telefone,
        String email,
        Usuario usuario
) {
    public EmpreiteiroResponse(Empreiteiro empreiteiro){
        this(
                empreiteiro.getName(),
                empreiteiro.getDocumento(),
                empreiteiro.getTelefone(),
                empreiteiro.getEmail(),
                empreiteiro.getUsuario()
        );
    }
}
