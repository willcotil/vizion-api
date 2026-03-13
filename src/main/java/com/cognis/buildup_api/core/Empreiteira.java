package com.cognis.buildup_api.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empreiteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 18, nullable = false)
    private String cnpj;

    @Column(length = 150, nullable = true)
    private String nome_fantasia;

    @Column(length = 150, nullable = false)
    private String razao_social;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
