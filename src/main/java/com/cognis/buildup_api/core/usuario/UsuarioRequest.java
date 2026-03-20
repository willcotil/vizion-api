package com.cognis.buildup_api.core.usuario;


import lombok.Data;
@Data

public class UsuarioRequest {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String status;
    private UsuarioRole role;
    private String tenant_id;

}