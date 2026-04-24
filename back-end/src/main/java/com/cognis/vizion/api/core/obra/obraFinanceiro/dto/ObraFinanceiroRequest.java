package com.cognis.vizion.api.core.obra.obraFinanceiro.dto;


import com.cognis.vizion.api.core.obra.obraFinanceiro.TipoFinanceiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ObraFinanceiroRequest(
        String descricao,
        TipoFinanceiro tipo_financeiro,
        BigDecimal valor,
        LocalDate dataPagamento,
        LocalDate dataEstimado,
        boolean pago,
        Integer idObra,
        Integer idMaterial
) {
}