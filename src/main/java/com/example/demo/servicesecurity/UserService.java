package com.example.demo.servicesecurity;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NhanVienRepo nhanVienRepo;
    private final PasswordEncoder passwordEncoder;

    public String addUser(NhanVien nhanVien){
        nhanVien.setChucVu("ROLE_ADMIN");
        if(nhanVienRepo.findByTenDangNhapAndTrangThai(nhanVien.getTenDangNhap(),1).isPresent()){
            return "Tên đăng nhập đã tồn tại";
        }
        nhanVien.setMatKhau(passwordEncoder.encode(nhanVien.getMatKhau()));
        nhanVienRepo.save(nhanVien);
        return "Thêm thành công";
    }
}
