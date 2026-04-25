package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialRequest;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObraMaterialMapperImpl implements ObraMaterialMapper {

    @Override
    public ObraMaterialResponse toResponse(ObraMaterial entity) {
        if ( entity == null ) {
            return null;
        }

        int id_fase = 0;
        String nome_material = null;
        String descricao_material = null;
        BigDecimal valor_material = null;

        if ( entity.getId() != null ) {
            id_fase = entity.getId();
        }
        nome_material = entity.getNome_material();
        descricao_material = entity.getDescricao_material();
        valor_material = entity.getValor_material();

        ObraMaterialResponse obraMaterialResponse = new ObraMaterialResponse( nome_material, descricao_material, valor_material, id_fase );

        return obraMaterialResponse;
    }

    @Override
    public ObraMaterial toEntity(ObraMaterialRequest request) {
        if ( request == null ) {
            return null;
        }

        ObraMaterial obraMaterial = new ObraMaterial();

        obraMaterial.setNome_material( request.nome_material() );

        return obraMaterial;
    }
}
