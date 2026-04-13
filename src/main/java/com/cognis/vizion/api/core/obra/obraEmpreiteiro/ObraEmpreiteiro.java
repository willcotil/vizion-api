package com.cognis.vizion.api.core.obra.obraEmpreiteiro;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.obra.Obra;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "obra_empreiteiro")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObraEmpreiteiro extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "id_empreiteiro", nullable = false)
    private Empreiteiro empreiteiro;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_fim")
    private LocalDate data_fim;

    @Column(precision = 15, scale = 2)
    private BigDecimal valor_contratado;

    @Column(length = 20)
    private String status; // ATIVO, FINALIZADO, SUSPENSO
}
