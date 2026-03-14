package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
}
