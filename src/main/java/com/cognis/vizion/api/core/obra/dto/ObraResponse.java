package com.cognis.vizion.api.core.obra.dto;

import com.cognis.vizion.api.core.obra.Obra;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


public record ObraResponse(
         String nome_projeto,
         int id_endereco,
         Date data_inicio,
         Date data_previsao_entrega,
         BigDecimal valor_total_estimado,
         String status
) {
    public ObraResponse(Obra obra){
        this(
                obra.getNome_projeto(),
                obra.getId(),
                obra.getData_inicio(),
                obra.getData_previsao_entrega(),
                obra.getValor_total_estimado(),
                obra.getStatus()
        );
    }
}
