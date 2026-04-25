package com.cognis.vizion.api.core.tenent.dto;


import com.cognis.vizion.api.core.BaseEntity;

public record TenentIndentifierRequest (
        String nome,
        String tenant_id,
        Integer idEmpreiteira,
        Integer idCliente
) {
    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
