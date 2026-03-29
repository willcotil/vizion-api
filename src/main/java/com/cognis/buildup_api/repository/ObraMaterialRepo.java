package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.obra.obraMaterial.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraMaterialRepo extends JpaRepository<ObraMaterial, Integer> {
}
