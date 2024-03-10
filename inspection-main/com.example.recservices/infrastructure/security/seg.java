package com.example.recommendations.infrastructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/recomendacoes/**").permitAll() // Permite acesso a todas as URLs relacionadas às recomendações sem autenticação
                .anyRequest().authenticated() // Todas as outras requisições precisam de autenticação
            .and()
            .csrf().disable(); // Desabilita o CSRF (Cross-Site Request Forgery) para simplificar o exemplo
    }
}
