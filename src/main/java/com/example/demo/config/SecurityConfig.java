package com.example.demo.config;

import com.example.demo.repository.KhachHangRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.servicesecurity.CustomAuthenticationSuccessHandler;
import com.example.demo.servicesecurity.CustomLogoutSuccessHandler;
import com.example.demo.servicesecurity.UserInfoService;
import com.example.demo.servicesecuritykh.KhInfoService;
import com.example.demo.servicesecuritykh.KhInfoUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
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
                        .requestMatchers(new AntPathRequestMatcher("/gio-hang")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/danh-sach-yt/hien-thi")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/themngay/{sanPhamID}")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/danh-sach-yt/them/{sanPhamID}")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/themmoiny")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/thanh-toan")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/them-gio-hang/{sanPhamID}")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/detail6/{donHang}")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/thong-tin-van-chuyen")).hasAuthority("ROLE_USER")
                        .requestMatchers(new AntPathRequestMatcher("/nhan-vien")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/nhan-vien/page")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/san-pham")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/hien-thi")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/chat-lieu")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/mau-sac")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/nhap-kho")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/size")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/thuong-hieu")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/giam-gia")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/giam-gia/page")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/nha-cung-cap")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/giam-gia-chi-tiet")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/don-hang")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/hien-thi1")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/hien-thi2")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/long")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/longg")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/longgg")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/xemhuy")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/thongke")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/xemhuy")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/khach-hang")).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/khach-hang/page")).hasAuthority("ROLE_ADMIN")


                )
                .formLogin().loginPage("/login")
                .successHandler((request, response, authentication) -> {
                    for (
                            GrantedAuthority authority : authentication.getAuthorities()) {
                        if (authority.getAuthority().equals("ROLE_USER")) {
                            response.sendRedirect("/shop/main-shop");
                            return;
                        } else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                            response.sendRedirect("/trang-chu");
                            return;
                        }
                    }
                    // Default redirect if no matching role is found
                    response.sendRedirect("/");
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler())
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
@Bean("customAuthenticationSuccessHandler")
public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
    return new CustomAuthenticationSuccessHandler();
}
    @Bean("customLogoutSuccessHandler")
    public CustomLogoutSuccessHandler customLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
@Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}


}
