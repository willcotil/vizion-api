package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
}
