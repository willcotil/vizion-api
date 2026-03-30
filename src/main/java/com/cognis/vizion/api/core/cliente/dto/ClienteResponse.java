package com.cognis.vizion.api.core.cliente.dto;

import lombok.Data;

@Data
public class ClienteResponse {
    private String tenantid;

    private String name;

    private String documento;

    private String telefone;

    private String email;
}
