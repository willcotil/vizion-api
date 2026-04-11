package com.cognis.vizion.api.core.obra.obraFinanceiro.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ObraFinanceiroRequest {
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private LocalDate dataEstimado;
    private boolean pago;
    private Integer idObra;
}