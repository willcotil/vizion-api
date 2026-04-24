package com.cognis.vizion.api.core.obra.obraPropietarios;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.cliente.Cliente;
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

@Entity
@Table(name = "obra_proprietarios")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObraProprietarios extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(length = 50, nullable = false)
    private String tenant_id;

    @Column(length = 300)
    private String descricao_obra;

    @Column(precision = 5, scale = 2)
    private BigDecimal percentual_participacao;

    @Column(length = 20)
    private String status; // ATIVO, FINALIZADO, SUSPENSO
}
