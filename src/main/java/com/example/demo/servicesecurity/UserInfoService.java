package com.example.demo.servicesecurity;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    private final NhanVienRepo nhanVienRepo;

    public UserInfoService(NhanVienRepo nhanVienRepo) {
        this.nhanVienRepo = nhanVienRepo;
    }
    @Transactional
    public Optional<NhanVien> findByName(String tenDangNhap) {
        return nhanVienRepo.findByTenDangNhap(tenDangNhap);
    }

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        Optional<NhanVien> userInfo = nhanVienRepo.findByTenDangNhap(tenDangNhap);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + tenDangNhap));
    }
}
