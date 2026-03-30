package com.cognis.vizion.api.core.usuario;


import lombok.Data;
@Data

public class UsuarioRequest {
    private String email;
    private String senha;
    private String status;
    private UsuarioRole role;
}