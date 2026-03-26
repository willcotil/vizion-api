package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.tenent.TenentIndentifier;
import com.cognis.buildup_api.core.tenent.TenentIndentifierRequest;
import com.cognis.buildup_api.core.tenent.TenentIndentifierResponse;
import com.cognis.buildup_api.repository.TenentIndentifierRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenentIndentifierService extends BaseService<TenentIndentifier, TenentIndentifierRequest, TenentIndentifierResponse, Integer> {

    private final TenentIndentifierRepo repo;
    private final ModelMapper mapper;

    @Override protected JpaRepository<TenentIndentifier, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<TenentIndentifier> getEntityClass() { return TenentIndentifier.class; }
    @Override protected Class<TenentIndentifierResponse> getResponseClass() { return TenentIndentifierResponse.class; }

}

