package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.endereco.dto.EnderecoResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface EnderecoMapper extends CrudMapper<Endereco, EnderecoRequest, EnderecoResponse> {
}

