package com.cognis.vizion.api.core.estoque.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class EstoqueRequest {
    private Integer id_material;
    private BigDecimal quantidade_atual;
    private BigDecimal quantidade_minima;
    private BigDecimal quantidade_maxima;
    private String localizacao;
    private boolean ativo;
}
