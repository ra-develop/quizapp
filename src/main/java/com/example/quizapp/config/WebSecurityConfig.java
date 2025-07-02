package com.example.quizapp.config;

import com.example.quizapp.service.QuizUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	//Add code to handle web security with the help of QuizUserDetailsService class
    private final QuizUserDetailsService userDetailsService;

    public WebSecurityConfig(QuizUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/register", "/login", "/css/**").permitAll() // Allow access to registration and login pages
                        .requestMatchers("/quiz-list", "/add-quiz", "/edit-quiz", "/delete-quiz").hasRole("ADMIN") // Restrict /admin to users with the ADMIN role
                        .requestMatchers("/quiz", "/submit-quiz").hasRole("USER") // Restrict /viewer to users with the STAFF role
                        .anyRequest().authenticated() // Require authentication for all other endpoints
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/home", true) // Redirect to /home after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService) // Use your custom UserDetailsService
                .passwordEncoder(passwordEncoder()); // Use the password encoder
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
