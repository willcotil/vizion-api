package com.cognis.vizion.api.core.tenent.dto;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.tenent.TenentIndentifier;

public record TenentIndentifierResponse (
        String nome,
        String tenant_id,
        Empreiteira empreiteira,
        Cliente cliente
) {
    public TenentIndentifierResponse(TenentIndentifier tenentIndentifier){
        this(
                tenentIndentifier.getNome(),
                tenentIndentifier.getTenant_id(),
                tenentIndentifier.getEmpreiteira(),
                tenentIndentifier.getCliente()
        );
    }
    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
