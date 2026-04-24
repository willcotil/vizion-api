package com.cognis.vizion.api.core.obra.obraMaterial.dto;


import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;

import java.math.BigDecimal;

public record ObraMaterialResponse(
        String nome_material,
        String descricao_material,
        BigDecimal valor_material,
        int id_fase
) {
    public ObraMaterialResponse(ObraMaterial obraMaterial){
        this(
                obraMaterial.getNome_material(),
                obraMaterial.getDescricao_material(),
                obraMaterial.getValor_material(),
                obraMaterial.getId()
        );
    }
}
