package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObraMaterialRepo extends JpaRepository<ObraMaterial, Integer> {
    @Query("select om from ObraMaterial om where om.fases_obra.id = :faseId")
    List<ObraMaterial> findByFaseId(@Param("faseId") Integer faseId);
}
