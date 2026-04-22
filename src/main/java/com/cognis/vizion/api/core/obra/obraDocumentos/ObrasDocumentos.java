package com.cognis.vizion.api.core.obra.obraDocumentos;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.obra.Obra;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "obras_documentos")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObrasDocumentos extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", length = 20, nullable = false)
    private TipoDocumento tipo_documento;

    @Column(length = 100, nullable = false)
    private String nome_arquivo;

    @Column(length = 400, nullable = false)
    private String url_arquivo;

    @Column(length = 200)
    private String descricao_arquivo;
}
