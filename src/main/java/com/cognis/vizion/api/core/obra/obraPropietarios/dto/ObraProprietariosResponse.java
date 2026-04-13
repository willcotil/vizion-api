package com.cognis.vizion.api.core.obra.obraPropietarios.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ObraProprietariosResponse {
    private Integer id;
    private Integer id_obra;
    private Integer id_cliente;
    private String tenant_id;
    private String descricao_obra;
    private BigDecimal percentual_participacao;
    private String status;
}
