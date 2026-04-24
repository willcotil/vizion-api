package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreiteiroRepo extends JpaRepository<Empreiteiro, Integer> {
}
