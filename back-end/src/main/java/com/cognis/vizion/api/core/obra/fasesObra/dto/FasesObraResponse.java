package com.cognis.vizion.api.core.obra.fasesObra.dto;

import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;

import java.math.BigDecimal;
import java.util.Date;

public record FasesObraResponse (
        int id_fase,
        String nome_fase,
        String descricao,
        Date data_inicio_estimada,
        Date data_iniciada,
        Date data_fim_estimada,
        Date data_finalizada,
        BigDecimal valor_estimado,
        BigDecimal valor_pago,
        String status,
        int ordem_exibicao
){
    public FasesObraResponse(FasesObra fasesObra){
        this(
                fasesObra.getId(),
                fasesObra.getNome_fase(),
                fasesObra.getDescricao(),
                fasesObra.getData_inicio_estimada(),
                fasesObra.getData_iniciada(),
                fasesObra.getData_fim_estimada(),
                fasesObra.getData_finalizada(),
                fasesObra.getValor_estimado(),
                fasesObra.getValor_pago(),
                fasesObra.getStatus(),
                fasesObra.getOrdem_exibicao()
        );
    }
}
