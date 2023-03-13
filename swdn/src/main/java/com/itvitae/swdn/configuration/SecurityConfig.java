package com.itvitae.swdn.configuration;

import com.itvitae.swdn.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()

                .authorizeHttpRequests()
                .requestMatchers("/user/new/**", "/person/all")
                .hasRole("HR")

                .requestMatchers("/evaluation/trainee/**")
                .hasRole("TRAINEE")

                .requestMatchers("/skill/new/**", "/skill/update/**", "/skill/add/certificate/**")
                .hasAnyRole("TRAINEE", "COACH")

                .requestMatchers("/evaluation/new/**", "/evaluation/evaluator/**", "/role/trainee/all")
                .hasAnyRole("COACH", "MANAGER")

                .requestMatchers("/evaluation/get/**")
                .hasAnyRole("TRAINEE", "COACH", "MANAGER")

                .requestMatchers("/**")
                .permitAll()

                .and()
                .userDetailsService(myUserDetailsService)
                .httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
