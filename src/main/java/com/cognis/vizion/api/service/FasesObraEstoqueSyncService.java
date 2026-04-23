package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.TipoMovimentacao;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import com.cognis.vizion.api.infra.exception.ValidationException;
import com.cognis.vizion.api.repository.EstoqueRepo;
import com.cognis.vizion.api.repository.MovimentacaoEstoqueRepo;
import com.cognis.vizion.api.repository.ObraMaterialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FasesObraEstoqueSyncService {
    private final ObraMaterialRepo obraMaterialRepo;
    private final EstoqueRepo estoqueRepo;
    private final MovimentacaoEstoqueRepo movimentacaoEstoqueRepo;

    @Transactional
    public void registrarConsumoInicial(FasesObra fase) {
        if (fase == null || fase.getId() == null) {
            throw new ValidationException("Fase de obra invalida para sincronizar estoque");
        }

        List<ObraMaterial> materiais = obraMaterialRepo.findByFases_obra_Id(fase.getId());
        if (materiais.isEmpty()) {
            return;
        }

        String referencia = "FASE-" + fase.getId();
        String motivo = "Consumo de materiais ao iniciar fase de obra";

        for (ObraMaterial obraMaterial : materiais) {
            Estoque estoque = estoqueRepo.findFirstByMaterial_IdAndAtivoTrue(obraMaterial.getMaterial().getId())
                    .orElseThrow(() -> new ValidationException("Estoque nao encontrado para o material " + obraMaterial.getMaterial().getId()));

            BigDecimal quantidade = obraMaterial.getQuantidade();
            if (estoque.getQuantidade_atual().compareTo(quantidade) < 0) {
                throw new ValidationException("Estoque insuficiente para o material " + obraMaterial.getMaterial().getId());
            }

            estoque.setQuantidade_atual(estoque.getQuantidade_atual().subtract(quantidade));
            estoqueRepo.save(estoque);

            MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
            movimentacao.setEstoque(estoque);
            movimentacao.setTipo_movimentacao(TipoMovimentacao.SAIDA);
            movimentacao.setQuantidade(quantidade);
            movimentacao.setValor_unitario(obraMaterial.getValor_material());
            movimentacao.setMotivo(motivo);
            movimentacao.setReferencia(referencia);
            movimentacao.setData_movimentacao(LocalDateTime.now());
            movimentacaoEstoqueRepo.save(movimentacao);
        }
    }
}
