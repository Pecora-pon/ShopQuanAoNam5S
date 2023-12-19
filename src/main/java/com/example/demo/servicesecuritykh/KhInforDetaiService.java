package com.example.demo.servicesecuritykh;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KhInforDetaiService implements UserDetailsService {
    private KhachHangRepo khachHangRepo;
    @Transactional
    public Optional<KhachHang> findByName(String tenDangNhap){
        return khachHangRepo.findByusername(tenDangNhap);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<KhachHang> khachHang=khachHangRepo.findByUsernameAndTrangThai(username,3);
        return khachHang.map(KhInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found: "+username));
    }
}
