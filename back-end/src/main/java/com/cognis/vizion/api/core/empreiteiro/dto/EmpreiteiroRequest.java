package com.cognis.vizion.api.core.empreiteiro.dto;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;

public record EmpreiteiroRequest(
        String name,
        String email,
        String documento,
        String telefone,
        UsuarioRequest usuario
){
}
