package com.example.demo.servicesecuritykh;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KhService {
    private final KhachHangRepo khachHangRepo;
    private final PasswordEncoder passwordEncoder;
    public String addKH(KhachHang khachHang){
        khachHang.setChucVu("ROLE_USER");
        if(khachHangRepo.findByusername(khachHang.getUsername()).isPresent()){
            return "Tên đăng nhập đã tồn tại";
        }
        khachHang.setPassword(passwordEncoder.encode(khachHang.getPassword()));
        khachHangRepo.save(khachHang);
        return "Thêm thành công";
    }
}
