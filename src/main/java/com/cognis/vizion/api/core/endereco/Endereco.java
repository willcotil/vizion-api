package com.cognis.vizion.api.core.endereco;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 255, nullable = false)
    private String logradouro;
    @Column(length = 20, nullable = false)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @Column(length = 100, nullable = false)
    private String bairro;
    @Column(length = 100, nullable = false)
    private String cidade;
    @Column(length = 2, nullable = false)
    private String estado;
    @Column(length = 10)
    private String cep;
}
