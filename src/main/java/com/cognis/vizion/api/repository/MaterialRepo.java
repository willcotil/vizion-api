package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.estoque.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepo extends JpaRepository<Material, Integer> {
}
