package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.auth.RefreshToken;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.repository.RefreshTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${api.security.refresh.expiration:604800000}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepo refreshTokenRepository;

    public RefreshToken criarTokenAtualizacao(Usuario usuario) {
        refreshTokenRepository.deleteByUsuario(usuario);

        RefreshToken tokenAtualizacao = new RefreshToken();
        tokenAtualizacao.setUsuario(usuario);
        tokenAtualizacao.setDataExpiracao(Instant.now().plusMillis(refreshTokenDurationMs));
        tokenAtualizacao.setToken(UUID.randomUUID().toString());

        return refreshTokenRepository.save(tokenAtualizacao);
    }

    public RefreshToken verificarExpiracao(RefreshToken token) {
        if (token.getDataExpiracao().isBefore(Instant.now())) {
            refreshTokenRepository.delete(token);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token de atualização expirado");
        }
        return token;
    }
}
