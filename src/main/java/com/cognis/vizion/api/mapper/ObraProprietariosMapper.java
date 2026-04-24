package com.cognis.vizion.api.mapper;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.obraPropietarios.ObraProprietarios;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosRequest;
import com.cognis.vizion.api.core.obra.obraPropietarios.dto.ObraProprietariosResponse;
import com.cognis.vizion.api.infra.config.utils.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ObraProprietariosMapper extends CrudMapper<ObraProprietarios, ObraProprietariosRequest, ObraProprietariosResponse> {

    @Override
    @Mapping(target = "id_obra", source = "obra.id")
    @Mapping(target = "id_cliente", source = "cliente.id")
    ObraProprietariosResponse toResponse(ObraProprietarios entity);

    @Override
    @Mapping(target = "obra", source = "id_obra")
    @Mapping(target = "cliente", source = "id_cliente")
    ObraProprietarios toEntity(ObraProprietariosRequest request);

    default Obra mapObra(Integer id) {
        if (id == null) return null;
        Obra obra = new Obra();
        obra.setId(id);
        return obra;
    }

    default Cliente mapCliente(Integer id) {
        if (id == null) return null;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}

