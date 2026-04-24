package com.cognis.vizion.api.repository;

    import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraFinanceiroRepo extends JpaRepository<ObraFinanceiro, Integer> {
}