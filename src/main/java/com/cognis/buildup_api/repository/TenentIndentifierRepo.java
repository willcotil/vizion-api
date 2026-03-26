package com.cognis.buildup_api.repository;

import com.cognis.buildup_api.core.tenent.TenentIndentifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenentIndentifierRepo extends JpaRepository<TenentIndentifier, Integer> {
}
