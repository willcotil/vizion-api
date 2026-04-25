package com.cognis.vizion.api.core.cliente.dto;


public record ClienteRequest(
         String tenantid,
         String name,
         String documento,
         String telefone,
         String email
) {
}
