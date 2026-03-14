package com.cognis.buildup_api.core.cliente;

import lombok.Data;

@Data
public class ClienteRequest {
    private String tenantid;

    private String name;

    private String documento;

    private String telefone;

    private String email;
}
