package com.cognis.vizion.api.core.estoque;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Material extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String nome_material;

    @Column(length = 300)
    private String descricao_material;

    @Column(length = 20, nullable = false)
    private String unidade_medida;

    @Column(precision = 10, scale = 2, nullable = false)
    private java.math.BigDecimal preco_unitario;

    @Column(length = 50)
    private String categoria;

    @Column(nullable = false)
    private boolean ativo = true;
}
