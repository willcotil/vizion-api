package com.cognis.vizion.api.core.cliente.dto;
import com.cognis.vizion.api.core.cliente.Cliente;

public record ClienteResponse(
         String tenantid,
         String name,
         String documento,
         String telefone,
         String email
) {
    public ClienteResponse(Cliente cliente){
        this(
                cliente.getTenantId(),
                cliente.getName(),
                cliente.getDocumento(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }
}
