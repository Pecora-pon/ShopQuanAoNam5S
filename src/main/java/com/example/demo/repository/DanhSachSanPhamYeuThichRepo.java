package com.example.demo.repository;

import com.example.demo.entity.DanhSachSanPhamYeuThich;
import com.example.demo.entity.GiamGia;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachSanPhamYeuThichRepo extends JpaRepository<DanhSachSanPhamYeuThich,Integer> {
//    @Query("SELECT dsspyt FROM DanhSachSanPhamYeuThich dsspyt WHERE dsspyt.sanPham LIKE %?1%")
//    List<GiamGia> searchBydanhsachsanphamyeuthicid(int keyword);
}
