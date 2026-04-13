package com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ObraEmpreiteiroRequest {
    private Integer id_obra;
    private Integer id_empreiteiro;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private BigDecimal valor_contratado;
    private String status;
}
