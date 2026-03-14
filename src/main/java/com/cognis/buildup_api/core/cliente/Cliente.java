package com.cognis.buildup_api.core.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String tenantid;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String documento;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Email
    @Column(length = 150, nullable = false)
    private String email;
}
