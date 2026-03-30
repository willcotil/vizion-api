package com.cognis.vizion.api.core.tenent;

import com.cognis.vizion.api.core.BaseEntity;
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
