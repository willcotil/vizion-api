package com.cognis.vizion.api.core.obra.obraFinanceiro;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.Obra;
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
import java.time.LocalDate;

@Entity
@Table(name = "obra_financeiro")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObraFinanceiro extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoFinanceiro tipo; 

    @Column(precision = 21, scale = 6, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "data_estimado", nullable = false)
    private LocalDate dataEstimado;

    @Column(nullable = false)
    private boolean pago = false;

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;
}
