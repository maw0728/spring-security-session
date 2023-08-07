package com.example.springsecuritysession.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * packageName    : com.example.springsecuritysession.config.security
 * fileName       : SecurityConfig
 * author         : Mujin yoo
 * date           : 2023-08-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-07        Mujin yoo       최초 생성
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin()
        ;
        http
                .cors()
                .disable()
        ;
        http
                .csrf()
                .disable()
        ;
        http
                .logout()
                .deleteCookies()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
        ;
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .maximumSessions(1)
        ;
        http
                .rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(3600)
        ;
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
        ;
        http
                .httpBasic();
        return http.build();
    }
}
