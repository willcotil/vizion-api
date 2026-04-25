package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObraEmpreiteiroMapperImpl implements ObraEmpreiteiroMapper {

    @Override
    public ObraEmpreiteiroResponse toResponse(ObraEmpreiteiro entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_obra = null;
        Integer id_empreiteiro = null;
        Integer id = null;
        String tenant_id = null;
        String descricao_obra = null;
        LocalDate data_inicio = null;
        LocalDate data_fim = null;
        BigDecimal valor_contratado = null;
        String status = null;

        id_obra = entityObraId( entity );
        id_empreiteiro = entityEmpreiteiroId( entity );
        id = entity.getId();
        tenant_id = entity.getTenant_id();
        descricao_obra = entity.getDescricao_obra();
        data_inicio = entity.getData_inicio();
        data_fim = entity.getData_fim();
        valor_contratado = entity.getValor_contratado();
        status = entity.getStatus();

        ObraEmpreiteiroResponse obraEmpreiteiroResponse = new ObraEmpreiteiroResponse( id, id_obra, id_empreiteiro, tenant_id, descricao_obra, data_inicio, data_fim, valor_contratado, status );

        return obraEmpreiteiroResponse;
    }

    @Override
    public ObraEmpreiteiro toEntity(ObraEmpreiteiroRequest request) {
        if ( request == null ) {
            return null;
        }

        ObraEmpreiteiro obraEmpreiteiro = new ObraEmpreiteiro();

        obraEmpreiteiro.setObra( mapObra( request.id_obra() ) );
        obraEmpreiteiro.setEmpreiteiro( mapEmpreiteiro( request.id_empreiteiro() ) );
        obraEmpreiteiro.setTenant_id( request.tenant_id() );
        obraEmpreiteiro.setDescricao_obra( request.descricao_obra() );
        obraEmpreiteiro.setData_inicio( request.data_inicio() );
        obraEmpreiteiro.setData_fim( request.data_fim() );
        obraEmpreiteiro.setValor_contratado( request.valor_contratado() );
        obraEmpreiteiro.setStatus( request.status() );

        return obraEmpreiteiro;
    }

    private Integer entityObraId(ObraEmpreiteiro obraEmpreiteiro) {
        Obra obra = obraEmpreiteiro.getObra();
        if ( obra == null ) {
            return null;
        }
        return obra.getId();
    }

    private Integer entityEmpreiteiroId(ObraEmpreiteiro obraEmpreiteiro) {
        Empreiteiro empreiteiro = obraEmpreiteiro.getEmpreiteiro();
        if ( empreiteiro == null ) {
            return null;
        }
        return empreiteiro.getId();
    }
}
