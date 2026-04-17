package com.cognis.vizion.api.validator;

import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.infra.exception.ValidationException;
import com.cognis.vizion.api.repository.ObraRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObraValidator extends BaseValidator<ObraRequest>{

    private final ObraRepo repository;

    @Override
    protected void validarCampos(ObraRequest request) {


        if(request.data_inicio().before(request.data_previsao_entrega())) {
            throw new ValidationException("A data de início não pode ser maior que a data de entrega");
        }

    }

}