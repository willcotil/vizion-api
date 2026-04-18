package com.cognis.vizion.api.core.endereco;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "endereco", schema = "public")
public class Endereco extends BaseEntity {
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
