package com.cognis.vizion.api.core.obra.fasesObra.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FasesObraResponse {

    private int id_fase;
    private String nome_fase;
    private String descricao;
    private Date data_inicio_estimada;
    private Date data_iniciada;
    private Date data_fim_estimada;
    private Date data_finalizada;
    private BigDecimal valor_estimado;
    private BigDecimal valor_pago;
    private String status;
    private int ordem_exibicao;
}
