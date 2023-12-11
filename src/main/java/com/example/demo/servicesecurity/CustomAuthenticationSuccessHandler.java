package com.example.demo.servicesecurity;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            // Nếu là nhân viên, chuyển hướng đến trang chủ nhân viên
            response.sendRedirect("/trang-chu");
        } else if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
            // Nếu là khách hàng, chuyển hướng đến trang chủ khách hàng
            response.sendRedirect("/list-san-pham/page");
        } else {
            // Nếu có các vai trò khác, có thể xử lý tùy ý ở đây

        }
    }

}
