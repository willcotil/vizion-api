package com.cognis.vizion.api.core.auth.dto;

public record TokenRefreshResponse(
        String accessToken,
        String refreshToken
) {
}