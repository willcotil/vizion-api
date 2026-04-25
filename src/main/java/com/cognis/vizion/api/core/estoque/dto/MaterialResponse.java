package com.cognis.vizion.api.core.estoque.dto;


import com.cognis.vizion.api.core.estoque.Material;

import java.math.BigDecimal;

public record MaterialResponse(
        Integer id,
        String nome_material,
        String descricao_material,
        String unidade_medida,
        BigDecimal preco_unitario,
        String categoria,
        boolean ativo
) {
    public MaterialResponse(Material material){
        this(
                material.getId(),
                material.getNome_material(),
                material.getDescricao_material(),
                material.getUnidade_medida(),
                material.getPreco_unitario(),
                material.getCategoria(),
                material.isAtivo()
        );
    }
}
