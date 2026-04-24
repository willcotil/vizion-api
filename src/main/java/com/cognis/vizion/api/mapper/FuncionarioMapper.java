package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioRequest;
import com.cognis.vizion.api.core.funcionario.dto.FuncionarioResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface FuncionarioMapper extends CrudMapper<Funcionario, FuncionarioRequest, FuncionarioResponse> {

    @Override
    @Mapping(target = "tenantid", source = "tenantId")
    FuncionarioResponse toResponse(Funcionario entity);

    @Override
    @Mapping(target = "tenantId", source = "tenantid")
    @Mapping(target = "usuario", ignore = true)
    Funcionario toEntity(FuncionarioRequest request);
}

