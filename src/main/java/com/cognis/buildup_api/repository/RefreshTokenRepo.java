package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.auth.RefreshToken;
import com.cognis.buildup_api.core.usuario.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Transactional
    void deleteByUsuario(Usuario usuario);
}