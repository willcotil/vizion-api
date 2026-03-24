package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.auth.*;
import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.core.usuario.UsuarioRole;
import com.cognis.buildup_api.repository.RefreshTokenRepo;
import com.cognis.buildup_api.service.RefreshTokenService;
import com.cognis.buildup_api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var usuario = (Usuario) auth.getPrincipal();

        var token = tokenService.gerarToken(usuario);

        var refreshToken = refreshTokenService.createRefreshToken(usuario);

        return ResponseEntity.ok(new LoginResponse(
                token,
                refreshToken.getToken(),
                usuario.getNome(),
                usuario.getRole().name(),
                usuario.getTenant_id()
        ));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
        return refreshTokenRepo.findByToken(request.getRefreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUsuario)
                .map(usuario -> {
                    String accessToken = tokenService.gerarToken(usuario);
                    return ResponseEntity.ok(new TokenRefreshResponse(accessToken, request.getRefreshToken()));
                })
                .orElseThrow(() -> new RuntimeException("Refresh token não encontrado no banco!"));
    }
}
