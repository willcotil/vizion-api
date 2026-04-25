package com.cognis.vizion.api.facade;

import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraAcao;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraState;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraStateFactory;
import com.cognis.vizion.api.core.obra.fasesObra.state.FasesObraStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FasesObraFacade {
    private final FasesObraStateFactory stateFactory;

    public FasesObraStatus transicionarStatus(String statusAtual, FasesObraAcao acao) {
        FasesObraStatus atual = FasesObraStatus.from(statusAtual);
        FasesObraState state = stateFactory.getState(atual);
        return state.transicionar(acao);
    }

    public void transicionarStatus(FasesObra fasesObra, FasesObraAcao acao) {
        FasesObraStatus novoStatus = transicionarStatus(fasesObra.getStatus(), acao);
        fasesObra.setStatus(novoStatus.name());
    }
}

