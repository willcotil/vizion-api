package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.TipoFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroResponse;
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
public class ObraFinanceiroMapperImpl implements ObraFinanceiroMapper {

    @Override
    public ObraFinanceiroResponse toResponse(ObraFinanceiro entity) {
        if ( entity == null ) {
            return null;
        }

        TipoFinanceiro tipo_financeiro = null;
        Integer idObra = null;
        Integer idMaterial = null;
        Integer id = null;
        String descricao = null;
        BigDecimal valor = null;
        LocalDate dataPagamento = null;
        LocalDate dataEstimado = null;
        boolean pago = false;

        tipo_financeiro = entity.getTipo();
        idObra = entityObraId( entity );
        idMaterial = entityMaterialId( entity );
        id = entity.getId();
        descricao = entity.getDescricao();
        valor = entity.getValor();
        dataPagamento = entity.getDataPagamento();
        dataEstimado = entity.getDataEstimado();
        pago = entity.isPago();

        ObraFinanceiroResponse obraFinanceiroResponse = new ObraFinanceiroResponse( id, descricao, tipo_financeiro, valor, dataPagamento, dataEstimado, pago, idObra, idMaterial );

        return obraFinanceiroResponse;
    }

    @Override
    public ObraFinanceiro toEntity(ObraFinanceiroRequest request) {
        if ( request == null ) {
            return null;
        }

        ObraFinanceiro obraFinanceiro = new ObraFinanceiro();

        obraFinanceiro.setTipo( request.tipo_financeiro() );
        obraFinanceiro.setObra( mapObra( request.idObra() ) );
        obraFinanceiro.setMaterial( mapMaterial( request.idMaterial() ) );
        obraFinanceiro.setDescricao( request.descricao() );
        obraFinanceiro.setValor( request.valor() );
        obraFinanceiro.setDataPagamento( request.dataPagamento() );
        obraFinanceiro.setDataEstimado( request.dataEstimado() );
        obraFinanceiro.setPago( request.pago() );

        return obraFinanceiro;
    }

    private Integer entityObraId(ObraFinanceiro obraFinanceiro) {
        Obra obra = obraFinanceiro.getObra();
        if ( obra == null ) {
            return null;
        }
        return obra.getId();
    }

    private Integer entityMaterialId(ObraFinanceiro obraFinanceiro) {
        Material material = obraFinanceiro.getMaterial();
        if ( material == null ) {
            return null;
        }
        return material.getId();
    }
}
