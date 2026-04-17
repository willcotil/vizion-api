package com.cognis.vizion.api.core.obra.obraPropietarios.dto;


import com.cognis.vizion.api.core.obra.obraPropietarios.ObraProprietarios;

import java.math.BigDecimal;

public record ObraProprietariosResponse(
        Integer id,
        Integer id_obra,
        Integer id_cliente,
        String tenant_id,
        String descricao_obra,
        BigDecimal percentual_participacao,
        String status
) {
    public ObraProprietariosResponse(ObraProprietarios obraProprietarios){
        this(
                obraProprietarios.getId(),
                obraProprietarios.getId(),
                obraProprietarios.getId(),
                obraProprietarios.getTenant_id(),
                obraProprietarios.getDescricao_obra(),
                obraProprietarios.getPercentual_participacao(),
                obraProprietarios.getStatus()
        );
    }
}
