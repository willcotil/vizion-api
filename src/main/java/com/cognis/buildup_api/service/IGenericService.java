package com.cognis.buildup_api.service;

import java.util.List;

public interface IGenericService<REQ, RES, ID> {
    RES salvar(REQ request);
    RES atualizar(REQ request, ID id);
    List<RES> getAll();
    RES getOne(ID id);
    void deleteOne(ID id);
}