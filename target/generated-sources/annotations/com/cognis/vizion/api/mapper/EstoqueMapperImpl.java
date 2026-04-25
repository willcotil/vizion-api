package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.dto.EstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.EstoqueResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class EstoqueMapperImpl implements EstoqueMapper {

    @Override
    public EstoqueResponse toResponse(Estoque entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id_material = null;
        Integer id = null;
        BigDecimal quantidade_atual = null;
        BigDecimal quantidade_minima = null;
        BigDecimal quantidade_maxima = null;
        String localizacao = null;
        boolean ativo = false;

        id_material = entityMaterialId( entity );
        id = entity.getId();
        quantidade_atual = entity.getQuantidade_atual();
        quantidade_minima = entity.getQuantidade_minima();
        quantidade_maxima = entity.getQuantidade_maxima();
        localizacao = entity.getLocalizacao();
        ativo = entity.isAtivo();

        EstoqueResponse estoqueResponse = new EstoqueResponse( id, id_material, quantidade_atual, quantidade_minima, quantidade_maxima, localizacao, ativo );

        return estoqueResponse;
    }

    @Override
    public Estoque toEntity(EstoqueRequest request) {
        if ( request == null ) {
            return null;
        }

        Estoque estoque = new Estoque();

        estoque.setMaterial( map( request.id_material() ) );
        estoque.setQuantidade_atual( request.quantidade_atual() );
        estoque.setQuantidade_minima( request.quantidade_minima() );
        estoque.setQuantidade_maxima( request.quantidade_maxima() );
        estoque.setLocalizacao( request.localizacao() );
        estoque.setAtivo( request.ativo() );

        return estoque;
    }

    private Integer entityMaterialId(Estoque estoque) {
        Material material = estoque.getMaterial();
        if ( material == null ) {
            return null;
        }
        return material.getId();
    }
}
