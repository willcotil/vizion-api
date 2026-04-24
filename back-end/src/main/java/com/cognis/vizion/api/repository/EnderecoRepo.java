package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
