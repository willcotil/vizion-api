package com.cognis.vizion.api.service;

import com.cognis.vizion.api.core.cliente.Cliente;
import com.cognis.vizion.api.core.empreiteiro.Empreiteiro;
import com.cognis.vizion.api.core.funcionario.Funcionario;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.core.usuario.UsuarioRole;
import com.cognis.vizion.api.core.usuario.UsuarioStatus;
import com.cognis.vizion.api.core.usuario.dto.UsuarioRequest;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import com.cognis.vizion.api.mapper.UsuarioMapper;
import com.cognis.vizion.api.repository.ClienteRepo;
import com.cognis.vizion.api.repository.EmpreiteiroRepo;
import com.cognis.vizion.api.repository.FuncionarioRepo;
import com.cognis.vizion.api.repository.UsuarioRepo;
import com.cognis.vizion.api.validator.UsuarioValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, UsuarioRequest, UsuarioResponse, Integer> {

    private final UsuarioRepo repo;
    private final UsuarioMapper mapper;
    private final UsuarioValidator validator;
    private final PasswordEncoder encoder;
    private final EmpreiteiroRepo empreiteiroRepository;
    private final ClienteRepo clienteRepository;
    private final FuncionarioRepo funcionarioRepository;

    @Override protected JpaRepository<Usuario, Integer> getRepo() { return repo; }
    @Override protected UsuarioMapper getMapper() { return mapper; }
    @Override protected Class<Usuario> getEntityClass() { return Usuario.class; }
    @Override protected Class<UsuarioResponse> getResponseClass() { return UsuarioResponse.class; }

    @Override
    @Transactional
    public UsuarioResponse salvar(UsuarioRequest request) {
        validator.validar(request);
        Usuario entity = mapper.toEntity(request);
        entity.setSenha(encoder.encode(request.senha()));
        return mapper.toResponse(repo.save(entity));
    }

    public String getNomePorRole(Integer usuarioId, UsuarioRole role) {
        return switch (role) {
            case ADMIN -> "Administrador Sistema";
            case EMPREITEIRO -> empreiteiroRepository.findByUsuarioId(usuarioId.longValue())
                    .map(Empreiteiro::getName)
                    .orElse("Empreiteiro não encontrado");

            case CLIENTE -> clienteRepository.findByUsuarioId(usuarioId.longValue())
                    .map(Cliente::getName)
                    .orElse("Cliente não encontrado");

            case FUNCIONARIO -> funcionarioRepository.findByUsuarioId(usuarioId.longValue())
                    .map(Funcionario::getName)
                    .orElse("Funcionário não encontrado");
        };
    }
}
