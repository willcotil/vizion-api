package com.cognis.vizion.api.core.estoque.dto;

import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimentacaoEstoqueResponse {
    private Integer id;
    private Integer id_estoque;
    private MovimentacaoEstoque.TipoMovimentacao tipo_movimentacao;
    private BigDecimal quantidade;
    private BigDecimal valor_unitario;
    private String motivo;
    private String referencia;
    private LocalDateTime data_movimentacao;
    private String usuario_responsavel;
}
