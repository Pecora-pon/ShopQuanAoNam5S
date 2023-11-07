package com.example.demo.config;

import com.example.demo.repository.NhanVienRepo;
import com.example.demo.servicesecurity.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
private final NhanVienRepo nhanVienRepo;
@Bean
    public UserDetailsService userDetailsService(){
    return new UserInfoService(nhanVienRepo);
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/nhan-vien")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/trang-chu/login")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/chat-lieu")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/mau-sac")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/nhap-kho")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/size")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/thuong-hieu")).hasAuthority("ROLE_ADMIN")
                )
                .formLogin()
                .and()
                .build();
    }
@Bean
    public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
}
@Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
}
