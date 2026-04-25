package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.auth.RefreshToken;
import com.cognis.vizion.api.core.auth.*;
import com.cognis.vizion.api.core.auth.dto.LoginRequest;
import com.cognis.vizion.api.core.auth.dto.LoginResponse;
import com.cognis.vizion.api.core.auth.dto.RefreshTokenRequest;
import com.cognis.vizion.api.core.auth.dto.TokenRefreshResponse;
import com.cognis.vizion.api.core.usuario.dto.UsuarioResponse;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.repository.RefreshTokenRepo;
import com.cognis.vizion.api.service.RefreshTokenService;
import com.cognis.vizion.api.service.TokenService;
import com.cognis.vizion.api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class  AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest data) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var autenticacao = this.authenticationManager.authenticate(usuarioSenha);

        var usuario = (Usuario) autenticacao.getPrincipal();

        var token = tokenService.gerarToken(usuario);

        var tokenAtualizacao = refreshTokenService.criarTokenAtualizacao(usuario);

        return ResponseEntity.ok(new LoginResponse(
                token,
                tokenAtualizacao.getToken(),
                usuarioService.getNomePorRole(usuario.getId(), usuario.getRole()),
                usuario.getRole().name(),
                usuario.getTenant_id()
        ));
    }

    @PostMapping({"/refresh", "/refresh-token"})
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
        return refreshTokenRepo.findByToken(request.refreshToken())
                .map(refreshTokenService::verificarExpiracao)
                .map(RefreshToken::getUsuario)
                .map(usuario -> {
                    if (!usuario.isEnabled() || !usuario.isAccountNonLocked()) {
                        throw new ResponseStatusException(org.springframework.http.HttpStatus.FORBIDDEN, "Usuário sem acesso");
                    }

                    String accessToken = tokenService.gerarToken(usuario);
                    return ResponseEntity.ok(new TokenRefreshResponse(accessToken, request.refreshToken()));
                })
                .orElseThrow(() -> new ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Token de atualização não encontrado"));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponse> me(@AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(new UsuarioResponse(usuario));
    }
}
