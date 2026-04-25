package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepo extends JpaRepository<Obra, Integer> {
}
