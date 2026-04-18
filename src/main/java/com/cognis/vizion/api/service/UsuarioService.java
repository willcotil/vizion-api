package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;
import com.cognis.vizion.api.repository.UsuarioRepo;
import com.cognis.vizion.api.validator.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, UsuarioRequest, UsuarioResponse, Integer> {
    private final UsuarioRepo repo;
    private final ModelMapper mapper;
    private final UsuarioValidator validator;
    private final PasswordEncoder encoder;

    @Override protected JpaRepository<Usuario, Integer> getRepo() { return repo; }
    @Override protected ModelMapper getMapper() { return mapper; }
    @Override protected Class<Usuario> getEntityClass() { return Usuario.class; }
    @Override protected Class<UsuarioResponse> getResponseClass() { return UsuarioResponse.class; }

    @Override
    @Transactional
    public UsuarioResponse salvar(UsuarioRequest request) {

        validator.validar(request);

        Usuario entity = mapper.map(request, Usuario.class);

        entity.setSenha(encoder.encode(request.senha()));
        entity.setStatus(UsuarioStatus.PENDENTE);

        return mapper.map(repo.save(entity), UsuarioResponse.class);
    }

}

