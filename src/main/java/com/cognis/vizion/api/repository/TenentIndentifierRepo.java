package com.cognis.vizion.api.repository;

import com.cognis.vizion.api.core.tenent.TenentIndentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenentIndentifierRepo extends JpaRepository<TenentIndentifier, Integer> {
}
