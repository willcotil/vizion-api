package com.cognis.vizion.api.core.estoque.dto;

import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.TipoMovimentacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimentacaoEstoqueResponse (
        Integer id,
        Integer id_estoque,
        TipoMovimentacao tipo_movimentacao,
        BigDecimal quantidade,
        BigDecimal valor_unitario,
        String motivo,
        String referencia,
        LocalDateTime data_movimentacao,
        String usuario_responsavel
){
    public MovimentacaoEstoqueResponse(MovimentacaoEstoque movimentacao){
        this(
                movimentacao.getId(),
                movimentacao.getId(),
                movimentacao.getTipo_movimentacao(),
                movimentacao.getQuantidade(),
                movimentacao.getValor_unitario(),
                movimentacao.getMotivo(),
                movimentacao.getReferencia(),
                movimentacao.getData_movimentacao(),
                movimentacao.getUsuario_responsavel()
        );
    }
}
