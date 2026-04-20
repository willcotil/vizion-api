package com.cognis.vizion.api.core.estoque.dto;


import com.cognis.vizion.api.core.estoque.Estoque;

import java.math.BigDecimal;

public record EstoqueResponse(
        Integer id,
        Integer id_material,
        BigDecimal quantidade_atual,
        BigDecimal quantidade_minima,
        BigDecimal quantidade_maxima,
        String localizacao,
        boolean ativo
) {
    public EstoqueResponse(Estoque estoque){
        this(
                estoque.getId(),
                estoque.getId(),
                estoque.getQuantidade_atual(),
                estoque.getQuantidade_minima(),
                estoque.getQuantidade_maxima(),
                estoque.getLocalizacao(),
                estoque.isAtivo()
        );
    }
}
