package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface UsuarioMapper extends CrudMapper<Usuario, UsuarioRequest, UsuarioResponse> {

    @Override
    UsuarioResponse toResponse(Usuario entity);

    Usuario toEntity(UsuarioResponse response);
}

