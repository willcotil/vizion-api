package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.fasesObra.FasesObra;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface FasesObraMapper extends CrudMapper<FasesObra, FasesObraRequest, FasesObraResponse> {

    @Override
    FasesObraResponse toResponse(FasesObra entity);

    @Override
    @Mapping(target = "obra", source = "id_obra")
    FasesObra toEntity(FasesObraRequest request);

    default Obra map(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }
}

