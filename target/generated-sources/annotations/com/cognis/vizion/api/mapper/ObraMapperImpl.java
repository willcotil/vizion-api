package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class ObraMapperImpl implements ObraMapper {

    @Override
    public ObraResponse toResponse(Obra entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_endereco = null;
        String nome_projeto = null;
        Date data_inicio = null;
        Date data_previsao_entrega = null;
        BigDecimal valor_total_estimado = null;
        String status = null;

        id_endereco = entityEnderecoId( entity );
        nome_projeto = entity.getNome_projeto();
        data_inicio = entity.getData_inicio();
        data_previsao_entrega = entity.getData_previsao_entrega();
        valor_total_estimado = entity.getValor_total_estimado();
        status = entity.getStatus();

        ObraResponse obraResponse = new ObraResponse( nome_projeto, id_endereco, data_inicio, data_previsao_entrega, valor_total_estimado, status );

        return obraResponse;
    }

    @Override
    public Obra toEntity(ObraRequest request) {
        if ( request == null ) {
            return null;
        }

        Obra obra = new Obra();

        obra.setEndereco( map( request.id_endereco() ) );
        obra.setTenant_id( request.tenant_id() );
        obra.setNome_projeto( request.nome_projeto() );
        obra.setData_inicio( request.data_inicio() );
        obra.setData_previsao_entrega( request.data_previsao_entrega() );
        obra.setValor_total_estimado( request.valor_total_estimado() );
        obra.setStatus( request.status() );

        return obra;
    }

    private Integer entityEnderecoId(Obra obra) {
        Endereco endereco = obra.getEndereco();
        if ( endereco == null ) {
            return null;
        }
        return endereco.getId();
    }
}
