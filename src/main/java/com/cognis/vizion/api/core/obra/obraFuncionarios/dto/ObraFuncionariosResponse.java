package com.cognis.vizion.api.core.obra.obraFuncionarios.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ObraFuncionariosResponse {
    private Integer id;
    private Integer id_obra;
    private Integer id_funcionario;
    private String tenant_id;
    private String descricao_obra;
    private String cargo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String status;
}
