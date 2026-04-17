package com.cognis.vizion.api.core.obra.obraPlanta.dto;


import com.cognis.vizion.api.core.obra.obraPlanta.ObraPlanta;

public record ObraPlantaResponse (
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo,
        Integer id_obra
) {
    public ObraPlantaResponse(ObraPlanta obraPlanta){
        this(
                obraPlanta.getNome_arquivo(),
                obraPlanta.getUrl_arquivo(),
                obraPlanta.getDescricao_arquivo(),
                obraPlanta.getId_obra()
        );
    }
}
