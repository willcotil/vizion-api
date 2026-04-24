package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
