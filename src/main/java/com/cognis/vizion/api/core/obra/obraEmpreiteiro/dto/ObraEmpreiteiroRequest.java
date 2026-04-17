package com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto;

import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ObraEmpreiteiroRequest(
        Integer id_obra,
        Integer id_empreiteiro,
        String tenant_id,
        String descricao_obra,
        LocalDate data_inicio,
        LocalDate data_fim,
        BigDecimal valor_contratado,
        String status
) {

}
