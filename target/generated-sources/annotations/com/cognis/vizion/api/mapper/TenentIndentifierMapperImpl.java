package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.tenent.TenentIndentifier;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierRequest;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class TenentIndentifierMapperImpl implements TenentIndentifierMapper {

    @Override
    public TenentIndentifierResponse toResponse(TenentIndentifier entity) {
        if ( entity == null ) {
            return null;
        }

        String nome = null;
        String tenant_id = null;
        Empreiteira empreiteira = null;
        Cliente cliente = null;

        nome = entity.getNome();
        tenant_id = entity.getTenant_id();
        empreiteira = entity.getEmpreiteira();
        cliente = entity.getCliente();

        TenentIndentifierResponse tenentIndentifierResponse = new TenentIndentifierResponse( nome, tenant_id, empreiteira, cliente );

        return tenentIndentifierResponse;
    }

    @Override
    public TenentIndentifier toEntity(TenentIndentifierRequest request) {
        if ( request == null ) {
            return null;
        }

        TenentIndentifier tenentIndentifier = new TenentIndentifier();

        tenentIndentifier.setEmpreiteira( mapEmpreiteira( request.idEmpreiteira() ) );
        tenentIndentifier.setCliente( mapCliente( request.idCliente() ) );
        tenentIndentifier.setNome( request.nome() );
        tenentIndentifier.setTenant_id( request.tenant_id() );

        return tenentIndentifier;
    }
}
