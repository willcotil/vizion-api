package com.cognis.vizion.api.core.funcionario.dto;

import lombok.Data;

@Data
public class FuncionarioResponse {
    private String tenantid;

    private String name;

    private String documento;

    private String telefone;

    private String email;
}
