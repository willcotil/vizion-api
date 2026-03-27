package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.obra.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepo extends JpaRepository<Obra, Integer> {
}
