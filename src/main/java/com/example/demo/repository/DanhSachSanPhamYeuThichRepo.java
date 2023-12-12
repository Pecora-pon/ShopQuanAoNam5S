package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhSachSanPhamYeuThichRepo extends JpaRepository<DanhSachSanPhamYeuThich,Integer> {
//    @Query("SELECT dsspyt FROM DanhSachSanPhamYeuThich dsspyt WHERE dsspyt.sanPham LIKE %?1%")
//    List<GiamGia> searchBydanhsachsanphamyeuthicid(int keyword);
boolean existsBySanPham_SanPhamID(UUID sp);
List<DanhSachSanPhamYeuThich>findByDanhSachYeuThich_KhachHang_Username(String username);
}
