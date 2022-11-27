package com.gb.tech.apiauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class JwtAccessTokenDto {
    private String token;
    private Long expiresAt = null;
    private String tokenType ="Bearer";


    public JwtAccessTokenDto(String accessToken, Long tokenExpiration) {
    }
}
