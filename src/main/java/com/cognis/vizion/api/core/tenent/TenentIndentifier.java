package com.cognis.vizion.api.core.tenent;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenent_indentifier", schema = "public")
@Data
@NoArgsConstructor
public class TenentIndentifier extends BaseEntity {

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false, unique = true)
    private String tenant_id;

    @ManyToOne
    @JoinColumn(name = "id_empreiteira", nullable = false)
    private Empreiteira empreiteira;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
