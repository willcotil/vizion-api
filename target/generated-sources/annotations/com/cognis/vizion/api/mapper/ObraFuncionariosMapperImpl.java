package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosResponse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObraFuncionariosMapperImpl implements ObraFuncionariosMapper {

    @Override
    public ObraFuncionariosResponse toResponse(ObraFuncionarios entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_obra = null;
        Integer id_funcionario = null;
        Integer id = null;
        String tenant_id = null;
        String descricao_obra = null;
        String cargo = null;
        LocalDate data_inicio = null;
        LocalDate data_fim = null;
        String status = null;

        id_obra = entityObraId( entity );
        id_funcionario = entityFuncionarioId( entity );
        id = entity.getId();
        tenant_id = entity.getTenant_id();
        descricao_obra = entity.getDescricao_obra();
        cargo = entity.getCargo();
        data_inicio = entity.getData_inicio();
        data_fim = entity.getData_fim();
        status = entity.getStatus();

        ObraFuncionariosResponse obraFuncionariosResponse = new ObraFuncionariosResponse( id, id_obra, id_funcionario, tenant_id, descricao_obra, cargo, data_inicio, data_fim, status );

        return obraFuncionariosResponse;
    }

    @Override
    public ObraFuncionarios toEntity(ObraFuncionariosRequest request) {
        if ( request == null ) {
            return null;
        }

        ObraFuncionarios obraFuncionarios = new ObraFuncionarios();

        obraFuncionarios.setObra( mapObra( request.id_obra() ) );
        obraFuncionarios.setFuncionario( mapFuncionario( request.id_funcionario() ) );
        obraFuncionarios.setTenant_id( request.tenant_id() );
        obraFuncionarios.setDescricao_obra( request.descricao_obra() );
        obraFuncionarios.setCargo( request.cargo() );
        obraFuncionarios.setData_inicio( request.data_inicio() );
        obraFuncionarios.setData_fim( request.data_fim() );
        obraFuncionarios.setStatus( request.status() );

        return obraFuncionarios;
    }

    private Integer entityObraId(ObraFuncionarios obraFuncionarios) {
        Obra obra = obraFuncionarios.getObra();
        if ( obra == null ) {
            return null;
        }
        return obra.getId();
    }

    private Integer entityFuncionarioId(ObraFuncionarios obraFuncionarios) {
        Funcionario funcionario = obraFuncionarios.getFuncionario();
        if ( funcionario == null ) {
            return null;
        }
        return funcionario.getId();
    }
}
