package com.cognis.vizion.api.core.empreiteira.dto;


import com.cognis.vizion.api.core.empreiteira.Empreiteira;


public record EmpreiteraResponse (
         Integer id,
         String nome_fantasia,
         String razao_social
) {
    public EmpreiteraResponse(Empreiteira empreiteira){
        this(
                empreiteira.getId(),
                empreiteira.getNome_fantasia(),
                empreiteira.getRazao_social()
        );
    }
}
