package com.gb.financial.assistant.lib.jwt;

@FunctionalInterface
public interface JwtParser {
    String parseTokenSubject(String token);
}