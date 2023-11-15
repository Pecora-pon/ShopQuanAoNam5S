package com.example.demo.servicesecuritykh;

import com.example.demo.entity.KhachHang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhInfoUserDetails implements UserDetails {

private String tenDangNhap;
private String password;
private List<GrantedAuthority> authorities;
public KhInfoUserDetails(KhachHang khachHang){
    tenDangNhap=khachHang.getUsername();
    password=khachHang.getPassword();
    authorities= Arrays.stream(khachHang.getChucVu().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
}
    @Override
    public String getUsername() {
        return tenDangNhap;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
