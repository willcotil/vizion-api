package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.ObraEmpreiteiro;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraEmpreiteiroMapper extends CrudMapper<ObraEmpreiteiro, ObraEmpreiteiroRequest, ObraEmpreiteiroResponse> {

    @Override
    @Mapping(target = "id_obra", source = "obra.id")
    @Mapping(target = "id_empreiteiro", source = "empreiteiro.id")
    ObraEmpreiteiroResponse toResponse(ObraEmpreiteiro entity);

    @Override
    @Mapping(target = "obra", source = "id_obra")
    @Mapping(target = "empreiteiro", source = "id_empreiteiro")
    ObraEmpreiteiro toEntity(ObraEmpreiteiroRequest request);

    default Obra mapObra(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }

    default Empreiteiro mapEmpreiteiro(Integer id) {
        if (id == null) return null;
        Empreiteiro empreiteiro = new Empreiteiro();
        empreiteiro.setId(id);
        return empreiteiro;
    }
}

