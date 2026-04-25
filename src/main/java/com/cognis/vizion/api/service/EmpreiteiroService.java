package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.vizion.api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import com.cognis.vizion.api.mapper.EmpreiteiroMapper;
import com.cognis.vizion.api.mapper.UsuarioMapper;
import com.cognis.vizion.api.repository.EmpreiteiroRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpreiteiroService extends BaseService<Empreiteiro, EmpreiteiroRequest, EmpreiteiroResponse, Integer> {

    private final EmpreiteiroRepo repo;
    private final EmpreiteiroMapper mapper;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;

    @Override protected JpaRepository<Empreiteiro, Integer> getRepo() { return repo; }
    @Override protected EmpreiteiroMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteiro> getEntityClass() { return Empreiteiro.class; }
    @Override protected Class<EmpreiteiroResponse> getResponseClass() { return EmpreiteiroResponse.class; }

    @Override
    @Transactional
    public EmpreiteiroResponse salvar(EmpreiteiroRequest request) {
        UsuarioRequest usuarioRequest =  new UsuarioRequest(
                request.email(),
                request.senha(),
                UsuarioStatus.ATIVO,
                UsuarioRole.EMPREITEIRO
        );
        UsuarioResponse usuario = usuarioService.salvar(usuarioRequest);
        Empreiteiro entity = mapper.toEntity(request);
        entity.setEmail(usuario.email());
        entity.setUsuario(usuarioMapper.toEntity(usuario));
        return mapper.toResponse(repo.save(entity));
    }
}
