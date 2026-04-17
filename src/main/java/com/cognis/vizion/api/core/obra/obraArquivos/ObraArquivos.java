package com.cognis.vizion.api.core.obra.obraArquivos;

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
public class ObraArquivos extends BaseEntity {

    @Column(length = 100)
    String nome_arquivo;

    @Column(length = 400)
    String url_arquivo;

    @Column(length = 200)
    String descricao_arquivo;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    private ObraArquivos obraArquivos;

}
