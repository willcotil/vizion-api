package com.cognis.vizion.api.core.obra.obraMaterial;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObraMaterial extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String tenant_id;

    @ManyToOne
    @JoinColumn(name = "id_fase")
    private FasesObra fases_obra;

    @ManyToOne  
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(nullable = false)
    private BigDecimal quantidade = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor_material;

    @Column(name = "data_alocacao")
    private LocalDate dataAlocacao;

}
