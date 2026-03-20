package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.usuario.Usuario;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private static final String ISSUER = "sua-api";
    private static final long EXPIRACAO_HORAS = 2;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .issuer(ISSUER)
                .subject(usuario.getEmail())
                .claim("role", usuario.getRole().name())
                .expiration(dataExpiracao())
                .signWith(getSecretKey())
                .compact();
    }

    public String validarToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (JwtException e) {
            return null;
        }
    }

    private Date     dataExpiracao() {
        return Date.from(
                LocalDateTime.now()
                        .plusHours(EXPIRACAO_HORAS)
                        .toInstant(ZoneOffset.of("-03:00"))
        );
    }
}