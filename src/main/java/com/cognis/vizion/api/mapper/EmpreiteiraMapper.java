package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteiraRequest;
import com.cognis.vizion.api.core.empreiteira.dto.EmpreiteraResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface EmpreiteiraMapper extends CrudMapper<Empreiteira, EmpreiteiraRequest, EmpreiteraResponse> {

    @Override
    EmpreiteraResponse toResponse(Empreiteira entity);

    @Override
    @Mapping(target = "cnpj", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Empreiteira toEntity(EmpreiteiraRequest request);
}

