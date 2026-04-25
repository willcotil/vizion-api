package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteiraRequest;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteraResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class EmpreiteiraMapperImpl implements EmpreiteiraMapper {

    @Override
    public EmpreiteraResponse toResponse(Empreiteira entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String nome_fantasia = null;
        String razao_social = null;

        id = entity.getId();
        nome_fantasia = entity.getNome_fantasia();
        razao_social = entity.getRazao_social();

        EmpreiteraResponse empreiteraResponse = new EmpreiteraResponse( id, nome_fantasia, razao_social );

        return empreiteraResponse;
    }

    @Override
    public Empreiteira toEntity(EmpreiteiraRequest request) {
        if ( request == null ) {
            return null;
        }

        Empreiteira empreiteira = new Empreiteira();

        empreiteira.setId( request.id() );
        empreiteira.setNome_fantasia( request.nome_fantasia() );
        empreiteira.setRazao_social( request.razao_social() );

        return empreiteira;
    }
}
