package com.cognis.vizion.api.core.obra.obraFinanceiro;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.obra.Obra;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ObraFinanceiro extends BaseEntity {
    @Column(length = 200, nullable = false)
    private String descricao;

    @Column(precision = 21, scale = 6, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "data_estimado", nullable = false)
    private LocalDate dataEstimado;

    @Column(nullable = false)
    private boolean pago;

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;
}
