package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioRequest request) {
        if ( request == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setEmail( request.email() );
        usuario.setSenha( request.senha() );
        usuario.setStatus( request.status() );
        usuario.setRole( request.role() );

        return usuario;
    }

    @Override
    public UsuarioResponse toResponse(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String email = null;
        UsuarioStatus status = null;
        UsuarioRole role = null;
        String tenant_id = null;

        id = entity.getId();
        email = entity.getEmail();
        status = entity.getStatus();
        role = entity.getRole();
        tenant_id = entity.getTenant_id();

        UsuarioResponse usuarioResponse = new UsuarioResponse( id, email, status, role, tenant_id );

        return usuarioResponse;
    }

    @Override
    public Usuario toEntity(UsuarioResponse response) {
        if ( response == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( response.id() );
        usuario.setEmail( response.email() );
        usuario.setStatus( response.status() );
        usuario.setRole( response.role() );
        usuario.setTenant_id( response.tenant_id() );

        return usuario;
    }
}
