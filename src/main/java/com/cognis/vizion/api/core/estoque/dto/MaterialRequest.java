package com.cognis.vizion.api.core.estoque.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MaterialRequest {
    private String nome_material;
    private String descricao_material;
    private String unidade_medida;
    private BigDecimal preco_unitario;
    private String categoria;
    private boolean ativo;
}
