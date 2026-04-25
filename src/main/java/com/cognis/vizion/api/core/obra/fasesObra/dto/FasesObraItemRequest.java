package com.cognis.vizion.api.core.obra.fasesObra.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record FasesObraItemRequest(
        Integer id,
        @NotBlank String nome_fase,
        String descricao,
        @NotNull Date data_inicio_estimada,
        Date data_iniciada,
        Date data_fim_estimada,
        Date data_finalizada,
        @NotNull @DecimalMin("0.0") BigDecimal valor_estimado,
        @NotNull @DecimalMin("0.0") BigDecimal valor_pago,
        @NotBlank String status,
        @NotNull @Min(0) Integer ordem_exibicao
) {
}

