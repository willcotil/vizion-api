package com.cognis.buildup_api.core.obra.fases_obra.obra_material;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ObraMaterialResponse {

    private String nome_material;
    private String descricao_material;
    private BigDecimal valor_material;
    private int id_fase;
}
