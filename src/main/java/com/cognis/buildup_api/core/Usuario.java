package com.cognis.buildup_api.core;

import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 155, nullable = false)
    private String nome;

    @CPF
    @Column(length = 14, nullable = false)
    private String cpf;

    @Email
    @Column(length = 150, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String senha;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 50, nullable = false)
    private String role;

    @Column(length = 50)
    private String tenant_id;

    @OneToOne
    @JoinColumn(name = "id_empreiteira")
    private Empreiteira empreiteira;

}
