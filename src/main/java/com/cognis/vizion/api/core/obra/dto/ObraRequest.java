package com.cognis.vizion.api.core.obra.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record ObraRequest (
        @NotBlank String nome_projeto,
        String tenant_id,
        Integer id_endereco,
        @NotNull Date data_inicio,
        @NotNull Date data_previsao_entrega,
        @NotNull @DecimalMin("0.0") BigDecimal valor_total_estimado,
        @NotBlank String status
){ }
