package com.cognis.vizion.api.core.estoque;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MovimentacaoEstoque extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String tenant_id;

    @ManyToOne
    @JoinColumn(name = "id_estoque", nullable = false)
    private Estoque estoque;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo_movimentacao;

    @Column(nullable = false)
    private BigDecimal quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor_unitario;

    @Column(length = 200)
    private String motivo;

    @Column(length = 100)
    private String referencia; // ex: "OBRA-123", "PO-456" para rastrear origem

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDateTime data_movimentacao;

    @Column(length = 100)
    private String usuario_responsavel;
}
