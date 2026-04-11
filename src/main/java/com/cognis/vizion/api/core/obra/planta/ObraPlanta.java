package com.cognis.vizion.api.core.obra.planta;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ObraPlanta extends BaseEntity {
    @Column(length = 100)
    private String nome_arquivo;
    @Column(length = 100)
    private String url_arquivo;
    @Column(length = 100)
    private String descricao_arquivo;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    private Integer id_obra;

}
