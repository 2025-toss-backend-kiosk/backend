package com.study.jskkiosk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // 개발 중이면 CSRF 비활성화
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/", "/swagger-ui/**", "/v3/api-docs/**").permitAll() // 여기서 허용할 경로들
//                        .anyRequest().authenticated() // 나머지는 인증 필요
//                )
//                .formLogin().disable(); // 로그인 폼도 비활성화 가능 (API 서버라면)

        http
                .csrf().disable() // CSRF 보호 비활성화 (API 서버라면 일반적)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청 허용
                );

        return http.build();
    }
}
