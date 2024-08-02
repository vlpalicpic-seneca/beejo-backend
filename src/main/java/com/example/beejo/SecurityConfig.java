package com.example.beejo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/movies/**",
                                "/series/**",
                                "/show/**",
                                "/movies",
                                "/series",
                                "/titleSearch",
                                "/login",
                                "/register",
                                "/user").permitAll()
                                .anyRequest().authenticated()
                );
    return http.build();
    }
}
