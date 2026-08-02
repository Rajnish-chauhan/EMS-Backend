//package com.project.employee_management.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                // 1. Enable CORS using the bean defined below
//                .cors(Customizer.withDefaults())
//
//                // 2. Disable CSRF (The modern, non-deprecated way using method reference)
//                .csrf(AbstractHttpConfigurer::disable)
//
//                // 3. Allow all API requests to pass through without authentication
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        // Add your allowed origins here (Localhost for testing, Live URL for production)
//        configuration.setAllowedOrigins(Arrays.asList(
//                "http://localhost:5173",
//                "https://ems.rajnishsystems.in"
//        ));
//
//        // Allow standard HTTP methods
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//
//        // Allow all headers
//        configuration.setAllowedHeaders(List.of("*"));
//
//        // Apply this configuration to all API endpoints
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
//}