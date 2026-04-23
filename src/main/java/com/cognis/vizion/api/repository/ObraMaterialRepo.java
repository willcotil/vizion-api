package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraMaterialRepo extends JpaRepository<ObraMaterial, Integer> {
    List<ObraMaterial> findByFases_obra_Id(Integer faseId);
}
