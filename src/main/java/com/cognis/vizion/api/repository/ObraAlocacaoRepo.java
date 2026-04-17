package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.obra.obraAlocacao.ObraAlocacaoEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraAlocacaoRepo extends JpaRepository<ObraAlocacaoEquipe, Integer> {
}