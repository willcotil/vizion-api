package com.cognis.vizion.api.core.estoque.dto;


import com.cognis.vizion.api.core.estoque.TipoMovimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimentacaoEstoqueRequest (
        Integer id_estoque,
        TipoMovimentacao tipo_movimentacao,
        BigDecimal quantidade,
        BigDecimal valor_unitario,
        String motivo,
        String referencia,
        LocalDateTime data_movimentacao,
        String usuario_responsavel
){

}
