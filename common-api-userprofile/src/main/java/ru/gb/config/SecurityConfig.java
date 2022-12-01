package ru.gb.config;

import com.gb.financial.assistant.lib.jwt.impl.JwtRsaParser;
import com.gb.financial.assistant.lib.jwt.spring.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private static final String[] AUTH_WHITELIST_HTTP = {
            //доступ к любой точке
//            "/**"
            //для доступа к swagger-ui
//            , "/v3/api-docs/**"
//            , "/swagger-ui/**"
    };

    @Value(value = "${PUBLIC_KEY}")
    String publicKey;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(@Value("publicKey") String publicKey) {
        return new JwtAuthenticationFilter(new JwtRsaParser(publicKey));
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthenticationFilter(publicKey), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST_HTTP)
                .permitAll();
        return http.build();
    }

}
