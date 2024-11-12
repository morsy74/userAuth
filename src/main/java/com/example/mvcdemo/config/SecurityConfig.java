package com.example.mvcdemo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authProvider);
    }
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http
          .authorizeHttpRequests(auth -> auth
            .requestMatchers("/","/signup","/about","/contact","/faq","/css/**","/js/**","images/**").permitAll()
            .requestMatchers("/profile","/general").hasAnyAuthority("USER")
            .requestMatchers("/management", "/general").hasAnyAuthority("ADMIN")
            .requestMatchers("/**").authenticated()
          )
          .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login") // URL to submit the login form
            .defaultSuccessUrl("/general", true)
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
          )
          .logout(logout -> logout
            .logoutSuccessUrl("/")
            .permitAll()
          )
          .build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    // Use allowedOriginPatterns instead of allowedOrigins
    configuration.setAllowedOriginPatterns(List.of("*")); // Allow all origins matching this pattern
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow specific methods
    configuration.setAllowedHeaders(List.of("*")); // Allow all headers
    configuration.setAllowCredentials(true); // Allow credentials to be included


    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration); // Apply CORS configuration to all endpoints
    return source;
  }
}
