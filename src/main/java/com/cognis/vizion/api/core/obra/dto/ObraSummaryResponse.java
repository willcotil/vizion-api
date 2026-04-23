package com.cognis.vizion.api.core.obra.dto;

import com.cognis.vizion.api.core.obra.Obra;

import java.math.BigDecimal;

public record ObraSummaryResponse(
        Integer id,
        String nome_projeto,
        Integer id_endereco,
        String status,
        java.util.Date data_inicio,
        java.util.Date data_previsao_entrega,
        BigDecimal valor_total_estimado,
        Integer total_fases,
        Integer fases_concluidas,
        BigDecimal valor_total_pago
) {
    public ObraSummaryResponse(Obra obra) {
        this(
                obra.getId(),
                obra.getNome_projeto(),
                obra.getEndereco() != null ? obra.getEndereco().getId() : null,
                obra.getStatus(),
                obra.getData_inicio(),
                obra.getData_previsao_entrega(),
                obra.getValor_total_estimado(),
                obra.getFases() != null ? obra.getFases().size() : 0,
                obra.getFases() != null
                        ? (int) obra.getFases().stream().filter(f -> "FINALIZADA".equalsIgnoreCase(f.getStatus())).count()
                        : 0,
                obra.getFinanceiro() != null
                        ? obra.getFinanceiro().stream()
                        .filter(f -> f.isPago() && f.getValor() != null)
                        .map(f -> f.getValor())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        : BigDecimal.ZERO
        );
    }
}
