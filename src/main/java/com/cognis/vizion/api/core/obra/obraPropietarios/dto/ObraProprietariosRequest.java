package com.cognis.vizion.api.core.obra.obraPropietarios.dto;


import java.math.BigDecimal;

public record ObraProprietariosRequest (
        Integer id_obra,
        Integer id_cliente,
        String tenant_id,
        String descricao_obra,
        BigDecimal percentual_participacao,
        String status
) {

}
