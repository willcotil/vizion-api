package com.cognis.vizion.api.core.estoque.dto;


import java.math.BigDecimal;

public record MaterialRequest(
        String nome_material,
        String descricao_material,
        String unidade_medida,
        BigDecimal preco_unitario,
        String categoria,
        boolean ativo
) {

}
