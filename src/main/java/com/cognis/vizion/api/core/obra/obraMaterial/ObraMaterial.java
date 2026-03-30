package com.cognis.vizion.api.core.obra.obraMaterial;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor

public class ObraMaterial extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_fase")
    private FasesObra fases_obra;
    @Column(length = 50, nullable = false)
    private String nome_material;
    @Column(length = 200)
    private String descricao_material;
    @Column(nullable = false)
    private BigDecimal valor_material;

}
