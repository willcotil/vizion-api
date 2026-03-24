package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
