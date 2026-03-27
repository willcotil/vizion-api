package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.obra.obra_proprietarios.ObraProprietarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraProprietarioRepo extends JpaRepository<ObraProprietarios, Integer> {
}
