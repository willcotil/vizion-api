package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.estoque.Material;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraFinanceiro.ObraFinanceiro;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroRequest;
import com.cognis.vizion.api.core.obra.obraFinanceiro.dto.ObraFinanceiroResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraFinanceiroMapper extends CrudMapper<ObraFinanceiro, ObraFinanceiroRequest, ObraFinanceiroResponse> {

    @Override
    @Mapping(target = "tipo_financeiro", source = "tipo")
    @Mapping(target = "idObra", source = "obra.id")
    @Mapping(target = "idMaterial", source = "material.id")
    ObraFinanceiroResponse toResponse(ObraFinanceiro entity);

    @Override
    @Mapping(target = "tipo", source = "tipo_financeiro")
    @Mapping(target = "obra", source = "idObra")
    @Mapping(target = "material", source = "idMaterial")
    ObraFinanceiro toEntity(ObraFinanceiroRequest request);

    default Obra mapObra(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }

    default Material mapMaterial(Integer id) {
        if (id == null) return null;
        Material material = new Material();
        material.setId(id);
        return material;
    }
}

