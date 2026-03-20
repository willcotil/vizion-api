package com.cognis.buildup_api.service;

import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.core.usuario.UsuarioRole;
import com.cognis.buildup_api.core.usuario.UsuarioStatus;
import com.cognis.buildup_api.repository.UsuarioRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepo usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));
    }

    @Autowired
    private UsuarioRepo userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public Usuario registrar(UsuarioRequest dto) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(encoder.encode(dto.getSenha()));
        novoUsuario.setRole(dto.getRole());

        if (dto.getRole() == UsuarioRole.EMPREITEIRO) {
            novoUsuario.setStatus(UsuarioStatus.PENDENTE);
        } else {
            novoUsuario.setStatus(UsuarioStatus.ATIVO);
        }

        return userRepository.save(novoUsuario);
    }
}
