package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.estoque.MovimentacaoEstoque;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueRequest;
import com.cognis.vizion.api.core.estoque.dto.MovimentacaoEstoqueResponse;
import com.cognis.vizion.api.repository.MovimentacaoEstoqueRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovimentacaoEstoqueService extends BaseService<MovimentacaoEstoque, MovimentacaoEstoqueRequest, MovimentacaoEstoqueResponse, Integer> {

    private final MovimentacaoEstoqueRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<MovimentacaoEstoque, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<MovimentacaoEstoque> getEntityClass() { return MovimentacaoEstoque.class; }
    @Override protected Class<MovimentacaoEstoqueResponse> getResponseClass() { return MovimentacaoEstoqueResponse.class; }
}
