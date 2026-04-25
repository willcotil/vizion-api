package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.cliente.dto.ClienteRequest;
import com.cognis.vizion.api.core.cliente.dto.ClienteResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteResponse toResponse(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        String tenantid = null;
        String name = null;
        String documento = null;
        String telefone = null;
        String email = null;

        tenantid = entity.getTenantId();
        name = entity.getName();
        documento = entity.getDocumento();
        telefone = entity.getTelefone();
        email = entity.getEmail();

        ClienteResponse clienteResponse = new ClienteResponse( tenantid, name, documento, telefone, email );

        return clienteResponse;
    }

    @Override
    public Cliente toEntity(ClienteRequest request) {
        if ( request == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setTenantId( request.tenantid() );
        cliente.setName( request.name() );
        cliente.setDocumento( request.documento() );
        cliente.setTelefone( request.telefone() );
        cliente.setEmail( request.email() );

        return cliente;
    }
}
