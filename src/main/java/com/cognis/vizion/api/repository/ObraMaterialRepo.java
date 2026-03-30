package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraMaterialRepo extends JpaRepository<ObraMaterial, Integer> {
}
