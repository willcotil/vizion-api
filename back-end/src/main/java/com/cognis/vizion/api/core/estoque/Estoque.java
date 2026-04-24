package com.cognis.vizion.api.core.estoque;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "estoque")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Estoque extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(nullable = false)
    private BigDecimal quantidade_atual = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal quantidade_minima = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal quantidade_maxima = BigDecimal.ZERO;

    @Column(length = 50)
    private String localizacao;

    @Column(nullable = false)
    private boolean ativo = true;
}
