package com.cognis.buildup_api.core.tenent;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class TenentIndentifierResponse extends BaseEntity {

    private String nome;
    private String tenant_id;
    private String empreiteiraNome;
    private String clienteNome;

    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
