package com.cognis.vizion.api.core.obra.obraFinanceiro.dto;

import com.cognis.vizion.api.core.obra.obraFinanceiro.TipoFinanceiro;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ObraFinanceiroItemRequest(
        Integer id,
        @NotBlank String descricao,
        @NotNull TipoFinanceiro tipo_financeiro,
        @NotNull @DecimalMin("0.0") BigDecimal valor,
        LocalDate dataPagamento,
        @NotNull LocalDate dataEstimado,
        boolean pago,
        Integer idMaterial
) {
}

