package com.gb.financial.assistant.lib.jwt.spring;

import com.gb.financial.assistant.lib.jwt.JwtParser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtParser jwtParser;

    private final int BEARER_PREFIX_SIZE = "Bearer ".length();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
        parseRequestToken(request).ifPresent(userId -> {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userId, null);
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(token);
        });
        filterChain.doFilter(request, response);
    }

    private Optional<String> parseRequestToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .map(header ->
                        header.length() > BEARER_PREFIX_SIZE ?
                                header.substring(BEARER_PREFIX_SIZE) : null)
                .map(jwtParser::parseTokenSubject);
    }
}
