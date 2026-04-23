package com.cognis.vizion.api.core.obra.fasesObra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class FasesObraStateFactory {
    private final Map<FasesObraStatus, FasesObraState> stateByStatus = new EnumMap<>(FasesObraStatus.class);

    public FasesObraStateFactory(List<FasesObraState> states) {
        for (FasesObraState state : states) {
            stateByStatus.put(state.getStatus(), state);
        }
    }

    public FasesObraState getState(FasesObraStatus status) {
        FasesObraState state = stateByStatus.get(status);

        if (state == null) {
            throw new ValidationException("Nao existe implementacao de state para o status " + status);
        }

        return state;
    }
}

