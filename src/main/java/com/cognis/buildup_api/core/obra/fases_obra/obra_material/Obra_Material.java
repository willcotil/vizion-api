package com.cognis.buildup_api.core.obra.fases_obra.obra_material;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.obra.fases_obra.Fases_Obra;
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

public class Obra_Material extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_fase")
    private Fases_Obra fases_obra;
    @Column(length = 50, nullable = false)
    private String nome_material;
    @Column(length = 200)
    private String descricao_material;
    @Column(nullable = false)
    private BigDecimal valor_material;
    @Column
    private int id_fase;
}
