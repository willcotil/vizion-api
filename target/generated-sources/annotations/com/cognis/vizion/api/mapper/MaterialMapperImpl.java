package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.dto.MaterialRequest;
import com.cognis.vizion.api.core.estoque.dto.MaterialResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-25T12:09:17-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class MaterialMapperImpl implements MaterialMapper {

    @Override
    public Material toEntity(MaterialRequest request) {
        if ( request == null ) {
            return null;
        }

        Material material = new Material();

        material.setNome_material( request.nome_material() );
        material.setDescricao_material( request.descricao_material() );
        material.setUnidade_medida( request.unidade_medida() );
        material.setPreco_unitario( request.preco_unitario() );
        material.setCategoria( request.categoria() );
        material.setAtivo( request.ativo() );

        return material;
    }

    @Override
    public MaterialResponse toResponse(Material entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String nome_material = null;
        String descricao_material = null;
        String unidade_medida = null;
        BigDecimal preco_unitario = null;
        String categoria = null;
        boolean ativo = false;

        id = entity.getId();
        nome_material = entity.getNome_material();
        descricao_material = entity.getDescricao_material();
        unidade_medida = entity.getUnidade_medida();
        preco_unitario = entity.getPreco_unitario();
        categoria = entity.getCategoria();
        ativo = entity.isAtivo();

        MaterialResponse materialResponse = new MaterialResponse( id, nome_material, descricao_material, unidade_medida, preco_unitario, categoria, ativo );

        return materialResponse;
    }
}
