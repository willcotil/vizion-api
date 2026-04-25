package com.cognis.vizion.api.validator;

import com.cognis.vizion.api.core.auth.dto.LoginRequest;
import com.cognis.vizion.api.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LoginValidator extends BaseValidator<LoginRequest> {

    @Override
    protected void validarCampos(LoginRequest request) {
        String email = request.email() == null
                ? ""
                : request.email().trim().toLowerCase(Locale.ROOT);

        if (email.isBlank()) {
            throw new ValidationException("Email é obrigatório");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new ValidationException("Email inválido");
        }

        if (request.senha() == null || request.senha().isBlank()) {
            throw new ValidationException("Senha é obrigatória");
        }
    }
}