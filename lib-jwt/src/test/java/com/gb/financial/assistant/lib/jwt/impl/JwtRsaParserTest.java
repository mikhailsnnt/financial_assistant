package com.gb.financial.assistant.lib.jwt.impl;

import com.gb.financial.assistant.lib.exception.security.JwtTokenExpiredException;
import com.gb.financial.assistant.lib.jwt.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import junit.framework.TestCase;
import lombok.SneakyThrows;
import org.junit.Assert;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtRsaParserTest extends TestCase {
    private JwtParser jwtParser;
    private PrivateKey privateKey;

    public void setUp() {
        jwtParser = new JwtRsaParser(SAMPLE_PUBLIC_KEY);
        privateKey = getSamplePrivateKey();
    }

    public void testParseTokenSubject() {
        String jwtToken = generateToken("104", LONG_TIME);
        Assert.assertEquals("104", jwtParser.parseTokenSubject(jwtToken));
    }

    @SneakyThrows
    public void testTokenExpire() {
        String jwtToken = generateToken("104", 1);
        Thread.sleep(100); //To make sure token is expired
        Assert.assertThrows(JwtTokenExpiredException.class, () -> jwtParser.parseTokenSubject(jwtToken));
    }

    private String generateToken(String userId, long expiresAt) {
        Date date = new Date();
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + expiresAt))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    @SneakyThrows
    private PrivateKey getSamplePrivateKey() {
        byte[] privateKeyBytes = Base64.getDecoder().decode(SAMPLE_PRIVATE_KEY.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return KeyFactory.getInstance("RSA").generatePrivate(keySpec);
    }

    private final long LONG_TIME = 1000000000;
    private final String SAMPLE_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCN3UHUvjcUMS3np1qTzna4WHoFR2fTDExlNur0b7M8eiMH5wemnX/OGyT0fFdlUc82UAcJL6i18eDdtJoBkiIUvtbXlHxC2WVCFz3f7yQqdb0Q3blXfjNLAd3JyiUnx1ZRgFbfQhRGdR03k3srX7gjQkSu0F2cwUMWQhXTp73CVBp7HDCYpWJstiVAAaHzeNZ6hChb7q9p6j6eJKhSv1tFWDgbf3t3PV6l2f4PVtffE1G/r9l3Lf4vhZPuM0fCLiZZ+Hr6j5HEOyIsDpqE0tC/mqqYZ2AQ9RjKgFssWWFfV1iRTJ+Jp3iitkm3iUAtvxCoU2wFfW50/eMG7+5yaOi3AgMBAAECggEBAIzu+R5zld5OeS9A9+AM5a5/30DtTjzBZAfNRh9t9J8pKzIHl3cz0qscFlt4R46VdoibelHq8e1HDUDT0Yer+IWpjV//2G7E8C53TnXwanpwG1LtItrDugtTIFX+p2jcRGmVWThUujXA1TTIJD3TyufkRr1wrP80lARBxNNPOloZjwzp/zF2pLnUb5ygEcSZKKMluoZmVoZ/00WLY1AnOSgTPNS5k8ZAqgGacep94zvKZS6aOow22N6N64nDeIv93qQdO85j9KOiJgACXM2lJkaz3anTNsiF/XefXTvW/cLPbbXuP2zY1WTV/u8W0dqOX0zawWLm9YW9BArisPcgaYECgYEA/gVI/JiSLkzJhOy8nTvyDymeUj0AmTT8VOVqFTDSnHu5DwIRPlvRyLLcxgoNoQA7A9TElDasDfFou/iZ1+8A81EYqYG5K2Zioaew9zB/L0WuLm591sVDahCDzZC7bVoZ04bLnhF7MhTIeA0RK1I16U3mJfCHmqSP6n4WbQK2/MECgYEAjvg+tg2N9KQQ563IA9hl8AvYwYdLHSzE4zNuidrWFH7zosFWNFTicd9DtqKG6YmSx2+PIrQrXhXIeHnoJWoEj0yBRx9etcNOvgdJrA7yaaOABAbl+7u6p8W4YoQzfQH/5kIPJU8jQDCYBR2aRDN/VQnCCOG+p+8y/uyoBqslK3cCgYAvzHbLcTowlCpnZNSpEZqe18n+15PBQIMqxnCLxEAdSfqspEryXPzAs0dvzHx8CzsPoX3MFe2SQhbfKAxq4YJgRqZJXyukywNMP+3A1dNY5de8zPXI8B2bW7gxekaKcSXi875k5A02g0qlrG/KoxGZ8RqZkQUzSDv8d/VoVdZxAQKBgQCK6X8dKmxcYDEgukRWICNjqk8QMuFz1nTzAJ0NirhpL7SP1eRpcnSXCcRkJuSI8yfPaYCcyow8nVOsY16BQ9JsXXxa24sNdlgC4VfeuqMkqz0OLJm3Dv9cVgtChYr1kkTOuC65JHxuuQhsKAgk7hhxSsriEF1MFGjrMoxL9mxmHwKBgQC6yiE1qZ4sLbTqJMNNtF7T4WvDpCLLGnQpSf7ACik6gczysHR+MFyRiwzxGzL1BiUORmDENZSAhj/p0O1amSYGrDRjdHVE2vWwrsCpkSrGtFZ/HAe/nHgqj1EIdojzn3X4Eez1wYPp67EsIzVbcckjIvo5gy5W4JONvNPVYpdVHg==";
    private final String SAMPLE_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjd1B1L43FDEt56dak852uFh6BUdn0wxMZTbq9G+zPHojB+cHpp1/zhsk9HxXZVHPNlAHCS+otfHg3bSaAZIiFL7W15R8QtllQhc93+8kKnW9EN25V34zSwHdycolJ8dWUYBW30IURnUdN5N7K1+4I0JErtBdnMFDFkIV06e9wlQaexwwmKVibLYlQAGh83jWeoQoW+6vaeo+niSoUr9bRVg4G397dz1epdn+D1bX3xNRv6/Zdy3+L4WT7jNHwi4mWfh6+o+RxDsiLA6ahNLQv5qqmGdgEPUYyoBbLFlhX1dYkUyfiad4orZJt4lALb8QqFNsBX1udP3jBu/ucmjotwIDAQAB";
}