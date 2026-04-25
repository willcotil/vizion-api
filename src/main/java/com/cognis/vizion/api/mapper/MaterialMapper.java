package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.estoque.dto.MaterialRequest;
import com.cognis.vizion.api.core.estoque.dto.MaterialResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface MaterialMapper extends CrudMapper<Material, MaterialRequest, MaterialResponse> {
}

