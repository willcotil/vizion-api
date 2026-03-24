package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.auth.RefreshToken;
import com.cognis.buildup_api.core.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUsuario(Usuario usuario);
}