package com.gb.financial.assistant.lib.jwt.impl;

import com.gb.financial.assistant.lib.exception.security.JwtTokenExpiredException;
import com.gb.financial.assistant.lib.jwt.JwtParser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class JwtRsaParser implements JwtParser {
    private final PublicKey publicKey;

    public JwtRsaParser(String encodedPublicKey) {
        publicKey = getPublicKey(encodedPublicKey);
    }

    public String parseTokenSubject(String token) {
        try {
            return Jwts.parser().setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            throw new JwtTokenExpiredException();
        }
    }

    @SneakyThrows
    private PublicKey getPublicKey(String encodedPublicKey) {
        byte[] keyBites = Base64.getDecoder().decode(encodedPublicKey.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBites);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }
}
