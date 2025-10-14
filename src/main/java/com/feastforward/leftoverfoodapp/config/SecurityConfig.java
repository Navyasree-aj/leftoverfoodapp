package com.feastforward.leftoverfoodapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // allow all requests
            .csrf().disable()  // disable CSRF for testing
            .formLogin().disable() // disable Spring default login page
            .httpBasic().disable(); // disable basic auth
        return http.build();
    }
}