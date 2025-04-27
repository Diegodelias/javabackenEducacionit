package com.educaionit.proyectoIntegregrador.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //permite controlar aplicaion desde controler
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        return http.csrf(csrf->csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .httpBasic(withDefaults())
         //   .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST,"/personas").hasAuthority("CREATE")
          //      .requestMatchers(HttpMethod.GET,"/personas").permitAll()) EN ESTE CASO NO ES NECESARIO PORQUE SE VA A USAR EnableMethodSecurity
        .build();

    }



    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
/*
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(){


        List users = new ArrayList<>();

        users.add(User.withUsername("educacionIt")
            .password("1234")
            .roles("ADMIN")
            //.authorities("UPDATE","DELETE","CREATE","DELETE")
            .build());

        users.add(User.withUsername("estudiante")
            .password("1234")
            .roles("ESTUDIANTE")
            //.authorities("READ")
            .build());

        users.add(User.withUsername("gerente")
            .password("1234")
            .roles("GERENTE")
            //.authorities("CREATE","READ")
            .build());
       // return username -> null;
        return new InMemoryUserDetailsManager(users);
/*
        return new InMemoryUserDetailsManager(
            User.withUsername("educacionIt")
                .password("1234")
                .roles("ADMIN")
              //  .authorities("UPDATE", "DELETE", "CREATE", "READ")
                .build(),
            User.withUsername("estudiante")
                .password("1234")
                .roles("ESTUDIANTE")
                //.authorities("READ")
                .build(),
            User.withUsername("Gerente")
                .password("1234")
                .roles("GERENTE")
             //   .authorities("CREATE", "READ")
                .build()
        );*/
    }

}
