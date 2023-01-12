package com.gb.tech.apiauth.service;

import com.gb.tech.apiauth.config.SecurityConfig;
import com.gb.tech.apiauth.dto.AuthDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.X509EncodedKeySpec;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class TokenService {

    private final SecurityConfig securityConfig;
    private final PrivateKey signKey;

    public TokenService(@Value("${jwt.secret}") String privateKey, SecurityConfig securityConfig){
        this.signKey = getPrivateKey(privateKey);
        this.securityConfig = securityConfig;
    }

    public AuthDto generateToken(long userId) {

        Date date = Date.from(ZonedDateTime.now().toInstant());
        Date expirationDate = Date.from(ZonedDateTime.now().plusSeconds(securityConfig.getTokenExpiration()).toInstant());
        String accessToken = Jwts.builder()
            .setClaims(Map.of("role", "USER"))
            .setSubject(String.valueOf(userId))
            .setIssuedAt(date)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.RS256, signKey)
            .compact();

        return new AuthDto(accessToken);
    }

    @SneakyThrows
    private PrivateKey getPrivateKey(String privateKey){
        byte[] keyBites = Base64.getDecoder().decode(privateKey.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBites);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }
}
