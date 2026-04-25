package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioRequest;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class FuncionarioMapperImpl implements FuncionarioMapper {

    @Override
    public FuncionarioResponse toResponse(Funcionario entity) {
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

        FuncionarioResponse funcionarioResponse = new FuncionarioResponse( tenantid, name, documento, telefone, email );

        return funcionarioResponse;
    }

    @Override
    public Funcionario toEntity(FuncionarioRequest request) {
        if ( request == null ) {
            return null;
        }

        Funcionario funcionario = new Funcionario();

        funcionario.setTenantId( request.tenantid() );
        funcionario.setName( request.name() );
        funcionario.setDocumento( request.documento() );
        funcionario.setTelefone( request.telefone() );
        funcionario.setEmail( request.email() );

        return funcionario;
    }
}
