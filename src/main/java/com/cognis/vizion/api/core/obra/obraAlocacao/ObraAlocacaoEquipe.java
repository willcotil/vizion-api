package com.cognis.vizion.api.core.obra.obraAlocacao;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "obra_alocacao_equipe")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ObraAlocacaoEquipe extends BaseEntity {

    @Column(name = "id_obra", nullable = false)
    private Integer id_obra;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "role_obra", length = 50, nullable = false)
    private String role_obra;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;
}