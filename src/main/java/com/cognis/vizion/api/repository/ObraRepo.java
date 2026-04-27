package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObraRepo extends JpaRepository<Obra, Integer> {
    @Query("SELECT o FROM Obra o " +
            "JOIN ObraEmpreiteiro oe ON oe.obra.id = o.id " +
            "WHERE oe.empreiteiro.usuario.id = :usuarioId " +
            "AND o.tenant_id = :tenantId")
    List<Obra> findByEmpreiteiroId(Integer usuarioId, String tenantId);
}
