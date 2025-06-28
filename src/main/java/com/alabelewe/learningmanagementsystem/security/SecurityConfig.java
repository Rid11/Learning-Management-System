package com.alabelewe.learningmanagementsystem.security;


import com.alabelewe.learningmanagementsystem.service.ProductService;
import com.alabelewe.learningmanagementsystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //Beans
    //bcrypt beans definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/app/products").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/app/products/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/app/products").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/app/products").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/app/products/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/app/lessons").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/app/lessons/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/app/lessons").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/app/lessons").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/app/lessons/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }

}
