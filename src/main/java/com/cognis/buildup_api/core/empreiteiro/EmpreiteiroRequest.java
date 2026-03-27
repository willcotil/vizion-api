package com.cognis.buildup_api.core.empreiteiro;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class EmpreiteiroRequest{

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String documento;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Email
    @Column(length = 150, nullable = false)
    private String email;

    @OneToOne(mappedBy = "id_usuario")
    private Usuario usuario;

}
