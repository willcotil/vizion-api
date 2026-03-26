package com.cognis.buildup_api.core.tenent;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TenentIndentifierRequest extends BaseEntity {

    private String nome;
    private String tenant_id;
    private Integer idEmpreiteira;
    private Integer idCliente;

    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
