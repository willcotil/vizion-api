package com.cognis.vizion.api.mapper;

public interface CrudMapper<T, REQ, RES> {
    T toEntity(REQ request);
    RES toResponse(T entity);
}

