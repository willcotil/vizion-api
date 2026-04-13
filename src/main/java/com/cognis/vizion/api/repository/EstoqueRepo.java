package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepo extends JpaRepository<Estoque, Integer> {
}
