package com.cognis.vizion.api.core.empreiteiro;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.core.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "empreiteiro", schema = "public")
@Data
public class Empreiteiro extends BaseEntity {

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String documento;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Email
    @Column(length = 150, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
