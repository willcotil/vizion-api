package com.cognis.vizion.api.core.obra.obraFinanceiro.dto;

import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ObraFinanceiroResponse {
    private Integer id;
    private String tenant_id;
    private String descricao;
    private ObraFinanceiro.TipoFinanceiro tipo_financeiro;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private LocalDate dataEstimado;
    private boolean pago;
    private Integer idObra;
    private Integer idMaterial;
}