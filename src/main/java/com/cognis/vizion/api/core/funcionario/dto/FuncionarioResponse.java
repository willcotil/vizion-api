package com.cognis.vizion.api.core.funcionario.dto;


public record FuncionarioResponse(
        String tenantid,
        String name,
        String documento,
        String telefone,
        String email
) {
    public FuncionarioResponse(FuncionarioResponse funcionario){
        this(
                funcionario.tenantid(),
                funcionario.name(),
                funcionario.documento(),
                funcionario.telefone(),
                funcionario.email()
        );
    }
}
