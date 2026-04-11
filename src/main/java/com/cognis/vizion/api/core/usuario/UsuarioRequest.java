package com.cognis.vizion.api.core.usuario;


import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UsuarioRequest {
    private String email;
    private String senha;
    private String status;
    private UsuarioRole role;
}