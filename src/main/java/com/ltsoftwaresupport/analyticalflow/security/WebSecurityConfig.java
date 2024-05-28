package com.ltsoftwaresupport.analyticalflow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author Lucas
 */
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
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))  // Habilitar CSRF com repositório de tokens baseados em cookies
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/", "/login").permitAll()  // Permitir acesso irrestrito à página principal e ao endpoint de login
//                        .anyRequest().authenticated()  // Requer autenticação para todas as outras rotas
//                )
//                .formLogin(form -> form
//                        .loginProcessingUrl("/")  // URL para submeter o formulário de login
//                        .permitAll()  // Permitir acesso irrestrito à URL de login
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")  // Configurar a URL de logout
//                        .logoutSuccessUrl("/")  // Redirecionar para a página inicial após logout bem-sucedido
//                        .permitAll()  // Permitir acesso irrestrito à URL de logout
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}