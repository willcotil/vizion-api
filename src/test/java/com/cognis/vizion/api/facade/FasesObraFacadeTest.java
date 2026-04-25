package com.cognis.vizion.api.facade;

import com.cognis.vizion.api.core.obra.fasesObra.state.*;
import com.cognis.vizion.api.infra.exception.ValidationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FasesObraFacadeTest {

    private FasesObraFacade buildFacade() {
        FasesObraStateFactory factory = new FasesObraStateFactory(List.of(
                new PlanejadaState(),
                new EmAndamentoState(),
                new PausadaState(),
                new FinalizadaState(),
                new CanceladaState()
        ));

        return new FasesObraFacade(factory);
    }

    @Test
    void deveIniciarFasePlanejada() {
        FasesObraFacade facade = buildFacade();

        FasesObraStatus novoStatus = facade.transicionarStatus("PLANEJADA", FasesObraAcao.INICIAR);

        assertEquals(FasesObraStatus.EM_ANDAMENTO, novoStatus);
    }

    @Test
    void deveFalharAoFinalizarFasePlanejada() {
        FasesObraFacade facade = buildFacade();

        assertThrows(ValidationException.class,
                () -> facade.transicionarStatus("PLANEJADA", FasesObraAcao.FINALIZAR));
    }
}

