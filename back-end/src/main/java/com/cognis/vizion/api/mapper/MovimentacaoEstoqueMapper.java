package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface MovimentacaoEstoqueMapper extends CrudMapper<MovimentacaoEstoque, MovimentacaoEstoqueRequest, MovimentacaoEstoqueResponse> {

    @Override
    @Mapping(target = "id_estoque", source = "estoque.id")
    MovimentacaoEstoqueResponse toResponse(MovimentacaoEstoque entity);

    @Override
    @Mapping(target = "estoque", source = "id_estoque")
    MovimentacaoEstoque toEntity(MovimentacaoEstoqueRequest request);

    default Estoque map(Integer id) {
        if (id == null) return null;
        Estoque estoque = new Estoque();
        estoque.setId(id);
        return estoque;
    }
}

