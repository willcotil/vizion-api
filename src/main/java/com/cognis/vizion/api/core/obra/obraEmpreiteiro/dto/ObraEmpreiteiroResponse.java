package com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ObraEmpreiteiroResponse {
    private Integer id;
    private Integer id_obra;
    private Integer id_empreiteiro;
    private String tenant_id;
    private String descricao_obra;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private BigDecimal valor_contratado;
    private String status;
}
