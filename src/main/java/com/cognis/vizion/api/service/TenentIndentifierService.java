package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.tenent.TenentIndentifier;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierRequest;
import com.cognis.vizion.api.core.tenent.dto.TenentIndentifierResponse;
import com.cognis.vizion.api.mapper.TenentIndentifierMapper;
import com.cognis.vizion.api.repository.TenentIndentifierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenentIndentifierService extends BaseService<TenentIndentifier, TenentIndentifierRequest, TenentIndentifierResponse, Integer> {

    private final TenentIndentifierRepo repo;
    private final TenentIndentifierMapper mapper;

    @Override protected JpaRepository<TenentIndentifier, Integer> getRepo() { return repo; }
    @Override protected TenentIndentifierMapper getMapper() { return mapper; }
    @Override protected Class<TenentIndentifier> getEntityClass() { return TenentIndentifier.class; }
    @Override protected Class<TenentIndentifierResponse> getResponseClass() { return TenentIndentifierResponse.class; }

}
