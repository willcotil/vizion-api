package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
