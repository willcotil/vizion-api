package com.cognis.vizion.api.core.empreiteiro.dto;

import com.cognis.vizion.api.core.usuario.UsuarioResponse;
import lombok.Data;

@Data
public class EmpreiteiroResponse {
    private String name;
    private String documento;
    private String telefone;
    private String email;
    private UsuarioResponse usuario;
}
