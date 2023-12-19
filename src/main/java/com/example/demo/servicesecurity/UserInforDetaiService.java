package com.example.demo.servicesecurity;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserInforDetaiService implements UserDetailsService {
 private NhanVienRepo nhanVienRepo;
 @Transactional
 public Optional<NhanVien> findByName(String tenDangNhap) {
  return nhanVienRepo.findByTenDangNhapAndTrangThai(tenDangNhap,1);
 }

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        Optional<NhanVien> nhanVien=nhanVienRepo.findByTenDangNhapAndTrangThai(tenDangNhap,1);
        return nhanVien.map(UserInfoUserDetails::new).orElseThrow(() ->new UsernameNotFoundException("user not found: "+tenDangNhap));
    }
}
