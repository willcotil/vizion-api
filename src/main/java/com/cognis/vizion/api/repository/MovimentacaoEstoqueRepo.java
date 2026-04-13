package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoEstoqueRepo extends JpaRepository<MovimentacaoEstoque, Integer> {
}
