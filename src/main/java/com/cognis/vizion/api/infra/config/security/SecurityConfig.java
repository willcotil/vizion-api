package com.cognis.vizion.api.infra.config.security;

import com.cognis.vizion.api.infra.config.tenant.TenantHttpFilter;
import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final TenantHttpFilter tenantHttpFilter;
    private final SecurityFilter securityFilter;

    public SecurityConfig(TenantHttpFilter tenantHttpFilter, SecurityFilter securityFilter) {
        this.tenantHttpFilter = tenantHttpFilter;
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/assets/**", "/favicon.ico", "/manifest.webmanifest", "/error").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/refresh", "/api/auth/refresh-token").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/auth/me").authenticated()

                        .requestMatchers(HttpMethod.POST, "/api/empreiteiro").permitAll()

                        .requestMatchers(HttpMethod.GET,
                                "/api/obra",
                                "/api/obra/**",
                                "/api/obraMaterial",
                                "/api/obraMaterial/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/fasesObra",
                                "/api/fasesObra/**",
                                "/api/obraProprietarios",
                                "/api/obraProprietarios/**"
                        ).hasAnyRole("CLIENTE", "EMPREITEIRO", "FUNCIONARIO", "ADMIN")
                        .requestMatchers(HttpMethod.GET,
                                "/api/obra-financeiro",
                                "/api/obra-financeiro/**",
                                "/api/obra-empreiteiro",
                                "/api/obra-empreiteiro/**",
                                "/api/empreiteira",
                                "/api/empreiteira/**"
                        ).hasAnyRole("EMPREITEIRO", "FUNCIONARIO", "ADMIN")
                        .requestMatchers(HttpMethod.GET,
                                "/api/obra-funcionarios",
                                "/api/obra-funcionarios/**",
                                "/api/endereco",
                                "/api/endereco/**"
                        ).hasAnyRole("FUNCIONARIO", "ADMIN")

                        .requestMatchers(HttpMethod.POST,
                                "/api/obra",
                                "/api/obra/**",
                                "/api/obraMaterial",
                                "/api/obraMaterial/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/fasesObra",
                                "/api/fasesObra/**",
                                "/api/obraProprietarios",
                                "/api/obraProprietarios/**",
                                "/api/obra-financeiro",
                                "/api/obra-financeiro/**",
                                "/api/obra-empreiteiro",
                                "/api/obra-empreiteiro/**",
                                "/api/obra-funcionarios",
                                "/api/obra-funcionarios/**",
                                "/api/endereco",
                                "/api/endereco/**"
                        ).hasAnyRole("FUNCIONARIO", "ADMIN")
                        .requestMatchers(HttpMethod.PUT,
                                "/api/obra",
                                "/api/obra/**",
                                "/api/obraMaterial",
                                "/api/obraMaterial/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/fasesObra",
                                "/api/fasesObra/**",
                                "/api/obraProprietarios",
                                "/api/obraProprietarios/**",
                                "/api/obra-financeiro",
                                "/api/obra-financeiro/**",
                                "/api/obra-empreiteiro",
                                "/api/obra-empreiteiro/**",
                                "/api/obra-funcionarios",
                                "/api/obra-funcionarios/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/endereco",
                                "/api/endereco/**"
                        ).hasAnyRole("FUNCIONARIO", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE,
                                "/api/obra",
                                "/api/obra/**",
                                "/api/obraMaterial",
                                "/api/obraMaterial/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/fasesObra",
                                "/api/fasesObra/**",
                                "/api/obraProprietarios",
                                "/api/obraProprietarios/**",
                                "/api/obra-financeiro",
                                "/api/obra-financeiro/**",
                                "/api/obra-empreiteiro",
                                "/api/obra-empreiteiro/**",
                                "/api/obra-funcionarios",
                                "/api/obra-funcionarios/**",
                                "/api/obrasDocumentos",
                                "/api/obrasDocumentos/**",
                                "/api/endereco",
                                "/api/endereco/**"
                        ).hasAnyRole("FUNCIONARIO", "ADMIN")

                        .requestMatchers("/api/usuario", "/api/usuario/**", "/api/cliente", "/api/cliente/**", "/api/funcionario", "/api/funcionario/**", "/api/tenent", "/api/tenent/**").hasRole("ADMIN")
                        .requestMatchers("/api/empreiteiro", "/api/empreiteiro/**").hasRole("ADMIN")

                        .anyRequest().hasRole("ADMIN")
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(tenantHttpFilter, SecurityFilter.class);

        return http.build();
    }

    @Bean
    static RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role("ADMIN").implies("EMPREITEIRO")
                .role("EMPREITEIRO").implies("FUNCIONARIO")
                .role("FUNCIONARIO").implies("CLIENTE")
                .build();
    }

    @Bean
    static MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);
        return handler;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
