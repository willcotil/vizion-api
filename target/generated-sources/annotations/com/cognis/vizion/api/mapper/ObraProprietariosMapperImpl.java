package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraPropietarios.ObraProprietarios;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosRequest;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObraProprietariosMapperImpl implements ObraProprietariosMapper {

    @Override
    public ObraProprietariosResponse toResponse(ObraProprietarios entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_obra = null;
        Integer id_cliente = null;
        Integer id = null;
        String tenant_id = null;
        String descricao_obra = null;
        BigDecimal percentual_participacao = null;
        String status = null;

        id_obra = entityObraId( entity );
        id_cliente = entityClienteId( entity );
        id = entity.getId();
        tenant_id = entity.getTenant_id();
        descricao_obra = entity.getDescricao_obra();
        percentual_participacao = entity.getPercentual_participacao();
        status = entity.getStatus();

        ObraProprietariosResponse obraProprietariosResponse = new ObraProprietariosResponse( id, id_obra, id_cliente, tenant_id, descricao_obra, percentual_participacao, status );

        return obraProprietariosResponse;
    }

    @Override
    public ObraProprietarios toEntity(ObraProprietariosRequest request) {
        if ( request == null ) {
            return null;
        }

        ObraProprietarios obraProprietarios = new ObraProprietarios();

        obraProprietarios.setObra( mapObra( request.id_obra() ) );
        obraProprietarios.setCliente( mapCliente( request.id_cliente() ) );
        obraProprietarios.setTenant_id( request.tenant_id() );
        obraProprietarios.setDescricao_obra( request.descricao_obra() );
        obraProprietarios.setPercentual_participacao( request.percentual_participacao() );
        obraProprietarios.setStatus( request.status() );

        return obraProprietarios;
    }

    private Integer entityObraId(ObraProprietarios obraProprietarios) {
        Obra obra = obraProprietarios.getObra();
        if ( obra == null ) {
            return null;
        }
        return obra.getId();
    }

    private Integer entityClienteId(ObraProprietarios obraProprietarios) {
        Cliente cliente = obraProprietarios.getCliente();
        if ( cliente == null ) {
            return null;
        }
        return cliente.getId();
    }
}
