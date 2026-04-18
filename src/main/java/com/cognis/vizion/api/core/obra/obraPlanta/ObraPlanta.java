package com.cognis.vizion.api.core.obra.obraPlanta;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.obra.Obra;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

}
