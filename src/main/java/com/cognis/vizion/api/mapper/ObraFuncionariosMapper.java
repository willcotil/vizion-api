package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraFuncionariosMapper extends CrudMapper<ObraFuncionarios, ObraFuncionariosRequest, ObraFuncionariosResponse> {

    @Override
    @Mapping(target = "id_obra", source = "obra.id")
    @Mapping(target = "id_funcionario", source = "funcionario.id")
    ObraFuncionariosResponse toResponse(ObraFuncionarios entity);

    @Override
    @Mapping(target = "obra", source = "id_obra")
    @Mapping(target = "funcionario", source = "id_funcionario")
    ObraFuncionarios toEntity(ObraFuncionariosRequest request);

    default Obra mapObra(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }

    default Funcionario mapFuncionario(Integer id) {
        if (id == null) return null;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        return funcionario;
    }
}

