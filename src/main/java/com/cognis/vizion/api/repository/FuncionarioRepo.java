package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByUsuarioId(Long usuarioId);
}
