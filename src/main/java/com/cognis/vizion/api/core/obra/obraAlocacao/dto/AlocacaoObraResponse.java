package com.cognis.vizion.api.core.obra.obraAlocacao.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AlocacaoObraResponse {
    private Integer id;
    private Integer id_obra;
    private Integer id_usuario;
    private String role_obra;
    private LocalDate data_inicio;
}