package com.cognis.vizion.api.core.obra.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ObraRequest {

    private String nome_projeto;
    private Date data_inicio;
    private Date data_previsao_entrega;
    private BigDecimal valor_total_estimado;


}
