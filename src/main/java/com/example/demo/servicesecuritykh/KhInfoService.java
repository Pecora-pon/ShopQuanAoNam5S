package com.example.demo.servicesecuritykh;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhInfoService implements UserDetailsService {
private final KhachHangRepo khachHangRepo;

    public KhInfoService(KhachHangRepo khachHangRepo) {
        this.khachHangRepo = khachHangRepo;
    }
@Transactional
public Optional<KhachHang> findByName(String tenDangNhap){
        return khachHangRepo.findByusername(tenDangNhap);
}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<KhachHang> userInfo=khachHangRepo.findByUsernameAndTrangThai(username,3);
        return userInfo.map(KhInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found"+username));
    }
}
