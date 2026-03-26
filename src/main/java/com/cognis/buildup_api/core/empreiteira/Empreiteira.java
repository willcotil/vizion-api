package com.cognis.buildup_api.core.empreiteira;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.endereco.Endereco;
import com.cognis.buildup_api.core.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empreiteira extends BaseEntity {

    @CNPJ
    @Column(length = 18, nullable = false)
    private String cnpj;

    @Column(length = 150, nullable = true)
    private String nome_fantasia;

    @Column(length = 150, nullable = false)
    private String razao_social;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
