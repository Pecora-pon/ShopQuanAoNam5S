package com.example.demo.config;

import com.example.demo.repository.KhachHangRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.servicesecurity.UserInfoService;
import com.example.demo.servicesecuritykh.KhInfoService;
import com.example.demo.servicesecuritykh.KhInfoUserDetails;
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
public class SecurityConfig  {
private final NhanVienRepo nhanVienRepo;
private final KhachHangRepo khachHangRepo;
@Bean
    public UserDetailsService userDetailsService(){
    return new UserInfoService(nhanVienRepo);
}
@Bean
public UserDetailsService userDetailsServicekh(){
    return new KhInfoService(khachHangRepo);
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/nhan-vien")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/gio-hang")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/them-gio-hang/{sanPhamID}")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/chat-lieu")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/mau-sac")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/nhap-kho")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/size")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/thuong-hieu")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/giam-gia")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/thong-tin-van-chuyen")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/giam-gia-chi-tiet")).hasAuthority("ROLE_ADMIN")
                )
                .formLogin().loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/trang-chu")
                .permitAll()
                .and()
                .userDetailsService(userDetailsService())
                .userDetailsService(userDetailsServicekh())
                .build();

    }
//@Bean
//    public AuthenticationProvider authenticationProvider(){
//    DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//    authenticationProvider.setUserDetailsService(userDetailsService());
//    authenticationProvider.setUserDetailsService(userDetailsServicekh());
//    authenticationProvider.setPasswordEncoder(passwordEncoder());
//    return authenticationProvider;
//}

@Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
}
