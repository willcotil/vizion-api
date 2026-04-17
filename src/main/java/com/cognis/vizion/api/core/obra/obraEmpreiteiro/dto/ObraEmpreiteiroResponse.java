package com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto;

import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ObraEmpreiteiroResponse (
        Integer id,
        Integer id_obra,
        Integer id_empreiteiro,
        String tenant_id,
        String descricao_obra,
        LocalDate data_inicio,
        LocalDate data_fim,
        BigDecimal valor_contratado,
        String status
) {
    public ObraEmpreiteiroResponse(ObraEmpreiteiro obraEmpreiteiro){
        this(
              obraEmpreiteiro.getId(),
              obraEmpreiteiro.getId(),
              obraEmpreiteiro.getId(),
              obraEmpreiteiro.getTenant_id(),
              obraEmpreiteiro.getDescricao_obra(),
              obraEmpreiteiro.getData_inicio(),
              obraEmpreiteiro.getData_fim(),
              obraEmpreiteiro.getValor_contratado(),
              obraEmpreiteiro.getStatus()
        );
    }
}
