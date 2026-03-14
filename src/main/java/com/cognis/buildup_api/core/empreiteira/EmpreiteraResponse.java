package com.cognis.buildup_api.core.empreiteira;


import lombok.Data;

@Data
public class EmpreiteraResponse {

    private Integer id;

    private String cnpj;

    private String nome_fantasia;

    private String razao_social;
}
