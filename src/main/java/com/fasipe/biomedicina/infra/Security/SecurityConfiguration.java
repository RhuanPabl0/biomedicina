package com.fasipe.biomedicina.infra.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(crsf -> crsf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/paciente").permitAll()
                        .requestMatchers(HttpMethod.GET, "/paciente/{cpfpac}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/procedimentos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/procedimentos/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/agenda").permitAll()
                        .requestMatchers(HttpMethod.GET, "/agenda/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/agenda/byUser/{userId}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/resultadoexame").permitAll()
                        .requestMatchers(HttpMethod.GET, "/resultadoexame/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/resultadoexame/profissional/{idprofissional}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/resultadoexame").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/login/{login}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/infoprocedimento").permitAll()
                        .requestMatchers(HttpMethod.GET, "/infoprocedimento/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/infoprocedimento").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inforeferencia").permitAll()
                        .requestMatchers(HttpMethod.GET, "/inforeferencia/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/exameseamostras").permitAll()
                        .requestMatchers(HttpMethod.GET, "/exameseamostras/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/exameseamostras").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
