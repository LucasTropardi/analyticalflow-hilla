package com.ltsoftwaresupport.analyticalflow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Forma atualizada de desabilitar CSRF
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // Permite acesso irrestrito a todas as rotas
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Incluído aqui por completude, mas não é necessário se não houver autenticação
        return new BCryptPasswordEncoder();
    }
}