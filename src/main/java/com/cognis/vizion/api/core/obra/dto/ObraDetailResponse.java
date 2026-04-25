package com.cognis.vizion.api.core.obra.dto;

import com.cognis.vizion.api.core.endereco.dto.EnderecoResponse;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosResponse;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record ObraDetailResponse(
        Integer id,
        String tenant_id,
        String nome_projeto,
        EnderecoResponse endereco,
        Date data_inicio,
        Date data_previsao_entrega,
        BigDecimal valor_total_estimado,
        String status,
        List<FasesObraResponse> fases,
        List<ObraFinanceiroResponse> financeiro,
        List<ObrasDocumentosResponse> documentos
) {
    public ObraDetailResponse(Obra obra) {
        this(
                obra.getId(),
                obra.getTenant_id(),
                obra.getNome_projeto(),
                obra.getEndereco() != null ? new EnderecoResponse(obra.getEndereco()) : null,
                obra.getData_inicio(),
                obra.getData_previsao_entrega(),
                obra.getValor_total_estimado(),
                obra.getStatus(),
                obra.getFases() != null ? obra.getFases().stream().map(FasesObraResponse::new).toList() : List.of(),
                obra.getFinanceiro() != null ? obra.getFinanceiro().stream().map(ObraFinanceiroResponse::new).toList() : List.of(),
                obra.getDocumentos() != null ? obra.getDocumentos().stream().map(ObrasDocumentosResponse::new).toList() : List.of()
        );
    }
}

