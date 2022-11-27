package com.gb.tech.apiauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDto {

    private JwtAccessTokenDto accessToken;
    private JwtRefreshTokenDto refreshToken;

}
