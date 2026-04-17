package com.cognis.vizion.api.core.obra.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

public record ObraRequest (
         String nome_projeto,
         Date data_inicio,
         Date data_previsao_entrega,
         BigDecimal valor_total_estimado
){ }
