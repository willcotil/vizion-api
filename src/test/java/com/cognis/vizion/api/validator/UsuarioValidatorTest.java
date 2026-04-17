package com.cognis.vizion.api.validator;

import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.infra.exception.ValidationException;
import com.cognis.vizion.api.repository.UsuarioRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioValidatorTest {

    @Mock
    private UsuarioRepo repository;

    @InjectMocks
    private UsuarioValidator validator;

    private UsuarioRequest criarRequest(String email, String senha) {
        return new UsuarioRequest(email, senha, "ATIVO", UsuarioRole.CLIENTE);
    }

    @Test
    @DisplayName("Deve validar com sucesso quando todos os dados forem válidos")
    void validarSucesso() {
        var request = criarRequest("teste@email.com", "senha123");
        when(repository.existsByEmail("teste@email.com")).thenReturn(false);

        assertDoesNotThrow(() -> validator.validarCampos(request));
    }

    @Test
    @DisplayName("Deve lançar exceção quando email for nulo")
    void validarEmailNulo() {
        var request = criarRequest(null, "senha123");

        var exception = assertThrows(ValidationException.class, () -> validator.validarCampos(request));
        assertEquals("Email é obrigatório", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"emailinvalido", "joao@", "@dominio.com", "espaço@email.com"})
    @DisplayName("Deve lançar exceção para formatos de email inválidos")
    void validarEmailInvalido(String emailInvalido) {
        var request = criarRequest(emailInvalido, "senha123");

        var exception = assertThrows(ValidationException.class, () -> validator.validarCampos(request));
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando o email já estiver cadastrado")
    void validarEmailDuplicado() {
        var email = "existente@email.com";
        var request = criarRequest(email, "senha123");
        when(repository.existsByEmail(email)).thenReturn(true);

        var exception = assertThrows(ValidationException.class, () -> validator.validarCampos(request));
        assertEquals("Email já cadastrado", exception.getMessage());
    }

    @Test
    @DisplayName("Deve normalizar email com maiúsculas para minúsculas antes de checar no banco")
    void deveNormalizarEmail() {
        var request = criarRequest("  TESTE@EMAIL.COM  ", "senha123");

        when(repository.existsByEmail("teste@email.com")).thenReturn(false);

        assertDoesNotThrow(() -> validator.validarCampos(request));
        verify(repository).existsByEmail("teste@email.com");
    }

    @Test
    @DisplayName("Deve lançar exceção quando a senha for menor que 6 caracteres")
    void validarSenhaCurta() {
        var request = criarRequest("teste@email.com", "12345");
        when(repository.existsByEmail("teste@email.com")).thenReturn(false);

        var exception = assertThrows(ValidationException.class, () -> validator.validarCampos(request));
        assertEquals("Senha deve ter no mínimo 6 caracteres", exception.getMessage());
    }
}