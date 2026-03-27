package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.obra.fases_obra.obra_material.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraMaterialRepo extends JpaRepository<ObraMaterial, Integer> {
}
