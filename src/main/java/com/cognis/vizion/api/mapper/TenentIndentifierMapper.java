package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.empreiteira.Empreiteira;
import com.cognis.vizion.api.core.tenent.TenentIndentifier;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierRequest;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface TenentIndentifierMapper extends CrudMapper<TenentIndentifier, TenentIndentifierRequest, TenentIndentifierResponse> {

    @Override
    TenentIndentifierResponse toResponse(TenentIndentifier entity);

    @Override
    @Mapping(target = "empreiteira", source = "idEmpreiteira")
    @Mapping(target = "cliente", source = "idCliente")
    TenentIndentifier toEntity(TenentIndentifierRequest request);

    default Empreiteira mapEmpreiteira(Integer id) {
        if (id == null) return null;
        Empreiteira entity = new Empreiteira();
        entity.setId(id);
        return entity;
    }

    default Cliente mapCliente(Integer id) {
        if (id == null) return null;
        Cliente entity = new Cliente();
        entity.setId(id);
        return entity;
    }
}

