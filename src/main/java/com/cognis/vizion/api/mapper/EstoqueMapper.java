package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Estoque;
import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.dto.EstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.EstoqueResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface EstoqueMapper extends CrudMapper<Estoque, EstoqueRequest, EstoqueResponse> {

    @Override
    @Mapping(target = "id_material", source = "material.id")
    EstoqueResponse toResponse(Estoque entity);

    @Override
    @Mapping(target = "material", source = "id_material")
    Estoque toEntity(EstoqueRequest request);

    default Material map(Integer id) {
        if (id == null) {
            return null;
        }
        Material material = new Material();
        material.setId(id);
        return material;
    }
}

