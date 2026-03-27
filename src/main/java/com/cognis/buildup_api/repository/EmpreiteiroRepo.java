package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.empreiteiro.Empreiteiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreiteiroRepo extends JpaRepository<Empreiteiro, Integer> {
}
