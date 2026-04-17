package com.cognis.vizion.api.core.funcionario.dto;


public record FuncionarioRequest(
        String tenantid,
        String name,
        String documento,
        String telefone,
        String email
) {

}
