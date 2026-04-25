package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface EmpreiteiroMapper extends CrudMapper<Empreiteiro, EmpreiteiroRequest, EmpreiteiroResponse> {

    @Override
    EmpreiteiroResponse toResponse(Empreiteiro entity);

    @Override
    @Mapping(target = "usuario", ignore = true)
    Empreiteiro toEntity(EmpreiteiroRequest request);
}

