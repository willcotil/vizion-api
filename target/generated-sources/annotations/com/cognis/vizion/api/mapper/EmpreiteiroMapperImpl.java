package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.vizion.api.core.usuario.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class EmpreiteiroMapperImpl implements EmpreiteiroMapper {

    @Override
    public EmpreiteiroResponse toResponse(Empreiteiro entity) {
        if ( entity == null ) {
            return null;
        }

        String name = null;
        String documento = null;
        String telefone = null;
        String email = null;
        Usuario usuario = null;

        name = entity.getName();
        documento = entity.getDocumento();
        telefone = entity.getTelefone();
        email = entity.getEmail();
        usuario = entity.getUsuario();

        EmpreiteiroResponse empreiteiroResponse = new EmpreiteiroResponse( name, documento, telefone, email, usuario );

        return empreiteiroResponse;
    }

    @Override
    public Empreiteiro toEntity(EmpreiteiroRequest request) {
        if ( request == null ) {
            return null;
        }

        Empreiteiro empreiteiro = new Empreiteiro();

        empreiteiro.setName( request.name() );
        empreiteiro.setDocumento( request.documento() );
        empreiteiro.setTelefone( request.telefone() );
        empreiteiro.setEmail( request.email() );

        return empreiteiro;
    }
}
