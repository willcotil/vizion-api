package com.cognis.buildup_api.core.obra.fasesObra;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.obra.Obra;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class FasesObra extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_obra")
    private Obra obra;
    @Column(length = 100, nullable = false)
    private String nome_fase;
    @Column(length = 500)
    private String descricao;
    @Column
    private Date data_inicio_estimada;
    @Column
    private Date data_iniciada;
    @Column
    private Date data_fim_estimada;
    @Column
    private Date data_finalizada;
    @Column
    private BigDecimal valor_estimado;
    @Column
    private BigDecimal valor_pago;
    @Column(length = 20, nullable = false)
    private String status;
    @Column
    private int ordem_exibicao;
}
