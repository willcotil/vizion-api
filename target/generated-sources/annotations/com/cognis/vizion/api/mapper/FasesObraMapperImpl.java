package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
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
public class FasesObraMapperImpl implements FasesObraMapper {

    @Override
    public FasesObraResponse toResponse(FasesObra entity) {
        if ( entity == null ) {
            return null;
        }

        String nome_fase = null;
        String descricao = null;
        Date data_inicio_estimada = null;
        Date data_iniciada = null;
        Date data_fim_estimada = null;
        Date data_finalizada = null;
        BigDecimal valor_estimado = null;
        BigDecimal valor_pago = null;
        String status = null;
        int ordem_exibicao = 0;

        nome_fase = entity.getNome_fase();
        descricao = entity.getDescricao();
        data_inicio_estimada = entity.getData_inicio_estimada();
        data_iniciada = entity.getData_iniciada();
        data_fim_estimada = entity.getData_fim_estimada();
        data_finalizada = entity.getData_finalizada();
        valor_estimado = entity.getValor_estimado();
        valor_pago = entity.getValor_pago();
        status = entity.getStatus();
        ordem_exibicao = entity.getOrdem_exibicao();

        int id_fase = 0;

        FasesObraResponse fasesObraResponse = new FasesObraResponse( id_fase, nome_fase, descricao, data_inicio_estimada, data_iniciada, data_fim_estimada, data_finalizada, valor_estimado, valor_pago, status, ordem_exibicao );

        return fasesObraResponse;
    }

    @Override
    public FasesObra toEntity(FasesObraRequest request) {
        if ( request == null ) {
            return null;
        }

        FasesObra fasesObra = new FasesObra();

        fasesObra.setObra( map( request.id_obra() ) );
        fasesObra.setNome_fase( request.nome_fase() );
        fasesObra.setDescricao( request.descricao() );
        fasesObra.setData_inicio_estimada( request.data_inicio_estimada() );
        fasesObra.setData_iniciada( request.data_iniciada() );
        fasesObra.setData_fim_estimada( request.data_fim_estimada() );
        fasesObra.setData_finalizada( request.data_finalizada() );
        fasesObra.setValor_estimado( request.valor_estimado() );
        fasesObra.setValor_pago( request.valor_pago() );
        fasesObra.setStatus( request.status() );
        if ( request.ordem_exibicao() != null ) {
            fasesObra.setOrdem_exibicao( request.ordem_exibicao() );
        }

        return fasesObra;
    }
}
