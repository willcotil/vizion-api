package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmpreiteiroRepo extends JpaRepository<Empreiteiro, Integer> {
    Optional<Empreiteiro> findByUsuarioId(Long usuarioId);
}
