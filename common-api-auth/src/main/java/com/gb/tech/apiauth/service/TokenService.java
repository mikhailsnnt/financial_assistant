package com.gb.tech.apiauth.service;

import com.gb.financial.assistant.lib.jwt.impl.JwtRsaParser;
import com.gb.tech.apiauth.config.SecurityConfig;
import com.gb.tech.apiauth.dto.AuthDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TokenService {

    private final SecurityConfig securityConfig;
    private final JwtRsaParser jwtRsaParser;
    private final PrivateKey signKey;

    public TokenService(@Value("${jwt.secret}") String privateKey, SecurityConfig securityConfig, JwtRsaParser jwtRsaParser){
        this.signKey = getPrivateKey(privateKey);
        this.securityConfig = securityConfig;
        this.jwtRsaParser = jwtRsaParser;
    }

    public AuthDto generateToken(Long userId) {

        Date date = Date.from(ZonedDateTime.now().toInstant());
        Date expirationDate = Date.from(ZonedDateTime.now().plusSeconds(securityConfig.getTokenExpiration()).toInstant());
        String accessToken = Jwts.builder()
            .setClaims(Map.of("role", "USER"))
            .setSubject(userId.toString())
            .setIssuedAt(date)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.RS256, signKey)
            .compact();

        return new AuthDto(accessToken);
    }

    public String parseClaims(String token)  {
        return jwtRsaParser.parseTokenSubject(token);
    }

    @SneakyThrows
    private PrivateKey getPrivateKey(String privateKey){
        byte[] keyBites = Base64.getDecoder().decode(privateKey.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBites);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }

}
