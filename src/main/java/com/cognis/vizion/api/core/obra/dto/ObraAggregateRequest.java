package com.cognis.vizion.api.core.obra.dto;

import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraItemRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosItemRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroItemRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;
import com.cognis.vizion.api.core.obra.obraPropietarios.ObraProprietarios;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record ObraAggregateRequest(
        @NotBlank String tenant_id,
        @NotBlank String nome_projeto,
        @NotNull @Valid EnderecoRequest endereco,
        @NotNull Date data_inicio,
        @NotNull Date data_previsao_entrega,
        @NotNull @DecimalMin("0.0") BigDecimal valor_total_estimado,
        @NotBlank String status,
        List<@Valid FasesObraItemRequest> fases,
        List<@Valid ObraFinanceiroItemRequest> financeiro,
        List<@Valid ObrasDocumentosItemRequest> documentos
) {
}
