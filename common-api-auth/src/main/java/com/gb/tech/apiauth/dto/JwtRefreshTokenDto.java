package com.gb.tech.apiauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRefreshTokenDto {

    private String token;
    private Long expiresAt = null;
}
