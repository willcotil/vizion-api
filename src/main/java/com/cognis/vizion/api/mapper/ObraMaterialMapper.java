package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.obraMaterial.ObraMaterial;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialRequest;
import com.cognis.vizion.api.core.obra.obraMaterial.dto.ObraMaterialResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraMaterialMapper extends CrudMapper<ObraMaterial, ObraMaterialRequest, ObraMaterialResponse> {

    @Override
    @Mapping(target = "id_fase", source = "id")
    ObraMaterialResponse toResponse(ObraMaterial entity);

    @Override
    ObraMaterial toEntity(ObraMaterialRequest request);
}

