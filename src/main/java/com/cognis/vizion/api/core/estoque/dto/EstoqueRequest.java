package com.cognis.vizion.api.core.estoque.dto;

import java.math.BigDecimal;

public record EstoqueRequest(
        Integer id_material,
        BigDecimal quantidade_atual,
        BigDecimal quantidade_minima,
        BigDecimal quantidade_maxima,
        String localizacao,
        boolean ativo
) {}
