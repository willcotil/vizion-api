package com.cognis.vizion.api.core.auth.dto;


public record LoginResponse (
         String accessToken,
         String refreshToken,
         String role,
         String tenantId
){
    public LoginResponse{
        if(accessToken == null || accessToken.isBlank()){
            throw new IllegalArgumentException("Token de acesso não pode ser nulo");
        }
    }
}