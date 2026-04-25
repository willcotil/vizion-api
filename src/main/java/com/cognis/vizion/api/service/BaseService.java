package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.BaseEntity;
import com.cognis.vizion.api.mapper.CrudMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class BaseService<T extends BaseEntity, REQ, RES, ID> implements IGenericService<REQ, RES, ID> {
    protected abstract JpaRepository<T, ID> getRepo();
    protected abstract CrudMapper<T, REQ, RES> getMapper();
    protected abstract Class<T> getEntityClass();
    protected abstract Class<RES> getResponseClass();

    @Override
    public RES salvar(REQ request) {
        T entity = getMapper().toEntity(request);
        return getMapper().toResponse(getRepo().save(entity));
    }

    @Override
    public List<RES> getAll() {
        return getRepo().findAll().stream()
                .map(getMapper()::toResponse)
                .toList();
    }

    @Override
    public RES getOne(ID id) {
        return getRepo().findById(id)
                .map(getMapper()::toResponse)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado: " + id));
    }

    @Override
    public void deleteOne(ID id) {
        if (!getRepo().existsById(id)) {
            throw new RuntimeException("Registro não encontrado para exclusão");
        }
        getRepo().deleteById(id);
    }


    @Override
    public RES atualizar(REQ request, ID id) {
        if (!getRepo().existsById(id)) {
            throw new RuntimeException("Registro não encontrado para atualização: " + id);
        }

        T entity = getMapper().toEntity(request);

        entity.setId((Integer) id);

        return getMapper().toResponse(getRepo().save(entity));
    }
}
