package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.empreiteiro.Empreiteiro;
import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.buildup_api.core.usuario.*;
import com.cognis.buildup_api.repository.EmpreiteiroRepo;
import com.cognis.buildup_api.repository.UsuarioRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpreiteiroService extends BaseService<Empreiteiro, EmpreiteiroRequest, EmpreiteiroResponse, Integer> {

    private final EmpreiteiroRepo repo;
    private final ModelMapper mapper;
    private final UsuarioService usuarioService;

    @Override protected JpaRepository<Empreiteiro, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteiro> getEntityClass() { return Empreiteiro.class; }
    @Override protected Class<EmpreiteiroResponse> getResponseClass() { return EmpreiteiroResponse.class; }

    @Override
    @Transactional
    public EmpreiteiroResponse salvar(EmpreiteiroRequest request) {
        UsuarioResponse usuario = usuarioService.salvar(request.getUsuario());
        Empreiteiro entity = getMapper().map(request, getEntityClass());
        entity.setEmail(usuario.getEmail());
        entity.setUsuario(mapper.map(usuario, Usuario.class));
        return getMapper().map(getRepo().save(entity), getResponseClass());
    }
}
