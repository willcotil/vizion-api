package com.cognis.vizion.api.core.tenent;

import com.cognis.vizion.api.core.BaseEntity;
import lombok.Data;

@Data
public class TenentIndentifierRequest extends BaseEntity {

    private String nome;
    private String tenant_id;
    private Integer idEmpreiteira;
    private Integer idCliente;

    ///@Enumerated(EnumType.STRING)
    ///private ObraStatus status;
}
