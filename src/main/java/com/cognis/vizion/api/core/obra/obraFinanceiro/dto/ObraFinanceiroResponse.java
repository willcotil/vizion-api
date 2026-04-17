package com.cognis.vizion.api.core.obra.obraFinanceiro.dto;


import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.TipoFinanceiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ObraFinanceiroResponse (
        Integer id,
        String descricao,
        TipoFinanceiro tipo_financeiro,
        BigDecimal valor,
        LocalDate dataPagamento,
        LocalDate dataEstimado,
        boolean pago,
        Integer idObra,
        Integer idMaterial
){
    public ObraFinanceiroResponse(ObraFinanceiro obraFinanceiro){
        this(
                obraFinanceiro.getId(),
                obraFinanceiro.getDescricao(),
                obraFinanceiro.getTipo(),
                obraFinanceiro.getValor(),
                obraFinanceiro.getDataPagamento(),
                obraFinanceiro.getDataEstimado(),
                obraFinanceiro.isPago(),
                obraFinanceiro.getId(),
                obraFinanceiro.getId()
        );
    }
}