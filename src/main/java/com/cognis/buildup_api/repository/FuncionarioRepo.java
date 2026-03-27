package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
}
