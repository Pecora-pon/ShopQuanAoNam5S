package com.example.demo.repository;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhSachYeuThichRepo extends JpaRepository<DanhSachYeuThich,Integer> {
    @Query("SELECT n FROM DanhSachYeuThich n where n.danhSachYeuThichID like %?1%")
    List<DanhSachYeuThich> searchByKhachHang(String keyword);

}
