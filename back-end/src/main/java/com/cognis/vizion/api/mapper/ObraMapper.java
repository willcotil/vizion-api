package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraMapper extends CrudMapper<Obra, ObraRequest, ObraResponse> {

    @Override
    @Mapping(target = "id_endereco", source = "endereco.id")
    ObraResponse toResponse(Obra entity);

    @Override
    @Mapping(target = "endereco", source = "id_endereco")
    Obra toEntity(ObraRequest request);

    default Endereco map(Integer id) {
        if (id == null) return null;
        Endereco endereco = new Endereco();
        endereco.setId(id);
        return endereco;
    }
}

