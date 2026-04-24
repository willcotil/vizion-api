package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.cliente.dto.ClienteRequest;
import com.cognis.vizion.api.core.cliente.dto.ClienteResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ClienteMapper extends CrudMapper<Cliente, ClienteRequest, ClienteResponse> {

    @Override
    @Mapping(target = "tenantid", source = "tenantId")
    ClienteResponse toResponse(Cliente entity);

    @Override
    @Mapping(target = "tenantId", source = "tenantid")
    @Mapping(target = "usuario", ignore = true)
    Cliente toEntity(ClienteRequest request);
}

