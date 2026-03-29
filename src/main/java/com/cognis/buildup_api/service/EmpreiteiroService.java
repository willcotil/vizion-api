package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.empreiteiro.Empreiteiro;
import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroRequest;
import com.cognis.buildup_api.core.empreiteiro.dto.EmpreiteiroResponse;
import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.core.usuario.UsuarioRole;
import com.cognis.buildup_api.core.usuario.UsuarioStatus;
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
    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder encoder;

    @Override protected JpaRepository<Empreiteiro, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Empreiteiro> getEntityClass() { return Empreiteiro.class; }
    @Override protected Class<EmpreiteiroResponse> getResponseClass() { return EmpreiteiroResponse.class; }

    @Override
    @Transactional
    public EmpreiteiroResponse salvar(EmpreiteiroRequest request) {
        UsuarioRequest usuario = request.getUsuario();
        Usuario usuarioEntity = mapper.map(usuario, Usuario.class);
        usuarioEntity.setSenha(encoder.encode(request.getUsuario().getSenha()));
        usuarioEntity.setRole(UsuarioRole.EMPREITEIRO);
        usuarioEntity.setStatus(UsuarioStatus.ATIVO);
        usuarioRepo.save(usuarioEntity);
        Empreiteiro entity = getMapper().map(request, getEntityClass());
        entity.setEmail(usuario.getEmail());
        entity.setUsuario(usuarioEntity);
        return getMapper().map(getRepo().save(entity), getResponseClass());
    }
}
