package com.cognis.vizion.api.core.obra.obraFuncionarios;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.obra.Obra;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "obra_funcionarios")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ObraFuncionarios extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_obra", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;

    @Column(length = 50, nullable = false)
    private String tenant_id;

    @Column(length = 300)
    private String descricao_obra;

    @Column(length = 50)
    private String cargo;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_fim")
    private LocalDate data_fim;

    @Column(length = 20)
    private String status; // ATIVO, FINALIZADO, SUSPENSO
}
