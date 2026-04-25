package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosRequest;
import com.cognis.vizion.api.core.obra.obraDocumentos.dto.ObrasDocumentosResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObrasDocumentosMapper extends CrudMapper<ObrasDocumentos, ObrasDocumentosRequest, ObrasDocumentosResponse> {

    @Override
    ObrasDocumentosResponse toResponse(ObrasDocumentos entity);

    @Override
    @Mapping(target = "obra", source = "id_obra")
    ObrasDocumentos toEntity(ObrasDocumentosRequest request);

    default Obra map(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }
}

