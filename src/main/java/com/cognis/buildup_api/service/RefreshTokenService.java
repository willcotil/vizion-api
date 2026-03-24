package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.auth.RefreshToken;
import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.repository.RefreshTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${api.security.refresh.expiration:604800000}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepo refreshTokenRepository;

    public RefreshToken createRefreshToken(Usuario usuario) {
        refreshTokenRepository.deleteByUsuario(usuario);

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUsuario(usuario);
        refreshToken.setDataExpiracao(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getDataExpiracao().isBefore(Instant.now())) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Por Favor, faça login novamente.");
        }
        return token;
    }
}