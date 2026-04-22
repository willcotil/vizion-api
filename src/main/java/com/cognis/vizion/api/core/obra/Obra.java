package com.cognis.vizion.api.core.obra;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Obra extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String tenant_id;
    @Column(length = 150, nullable = false)
    private String nome_projeto;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @Column(nullable = false)
    private Date data_inicio;
    @Column(nullable = false)
    private Date data_previsao_entrega;
    @Column(nullable = false)
    private BigDecimal valor_total_estimado;
    @Column(length = 20, nullable = false)
    private String status;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL)
    private List<ObraFinanceiro> financeiro;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObrasDocumentos> documentos;
}
