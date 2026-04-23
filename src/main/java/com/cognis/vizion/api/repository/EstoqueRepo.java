package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepo extends JpaRepository<Estoque, Integer> {
    Optional<Estoque> findFirstByMaterial_IdAndAtivoTrue(Integer materialId);
}
