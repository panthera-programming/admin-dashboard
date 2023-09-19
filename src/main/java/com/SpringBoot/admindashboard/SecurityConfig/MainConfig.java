package com.SpringBoot.admindashboard.SecurityConfig;

import com.SpringBoot.admindashboard.Service.ServiceImp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MainConfig{
    @Autowired
    private UserDetailsServiceImpl userDetails;
    @Autowired
    private CustomSuccessHandler loginSuccessHandler;
    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults()
    {
        return (new GrantedAuthorityDefaults(""));
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return (new BCryptPasswordEncoder());
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/js/**","/imgs/**","/register/firstAdmin","/setPassword").permitAll()
                        .requestMatchers("/adminHome/**").hasAuthority("Admin")
                        .anyRequest().authenticated()
                )
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                //.defaultSuccessUrl("/adminHome")
                                .successHandler(loginSuccessHandler)
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return (http.build());
    }
}
