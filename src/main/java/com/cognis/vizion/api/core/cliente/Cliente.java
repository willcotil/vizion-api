package com.cognis.vizion.api.core.cliente;

import com.cognis.vizion.api.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente extends BaseEntity {

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String documento;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Email
    @Column(length = 150, nullable = false)
    private String email;

    @Column(name = "usuario_id")
    private Integer usuarioId;
}
