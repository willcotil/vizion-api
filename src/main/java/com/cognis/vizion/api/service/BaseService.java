package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class BaseService<T extends BaseEntity, REQ, RES, ID> implements IGenericService<REQ, RES, ID> {
    protected abstract JpaRepository<T, ID> getRepo();
    protected abstract ModelMapper getMapper();
    protected abstract Class<T> getEntityClass();
    protected abstract Class<RES> getResponseClass();

    @Override
    public RES salvar(REQ request) {
        T entity = getMapper().map(request, getEntityClass());
        return getMapper().map(getRepo().save(entity), getResponseClass());
    }

    @Override
    public List<RES> getAll() {
        return getRepo().findAll().stream()
                .map(i -> getMapper().map(i, getResponseClass()))
                .toList();
    }

    @Override
    public RES getOne(ID id) {
        return getRepo().findById(id)
                .map(i -> getMapper().map(i, getResponseClass()))
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

        T entity = getMapper().map(request, getEntityClass());

        entity.setId((Integer) id);

        return getMapper().map(getRepo().save(entity), getResponseClass());
    }
}
