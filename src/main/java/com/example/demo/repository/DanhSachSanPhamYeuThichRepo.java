package com.example.demo.repository;

import com.example.demo.entity.DanhSachSanPhamYeuThich;
import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhSachSanPhamYeuThichRepo extends JpaRepository<DanhSachSanPhamYeuThich,Integer> {
}
