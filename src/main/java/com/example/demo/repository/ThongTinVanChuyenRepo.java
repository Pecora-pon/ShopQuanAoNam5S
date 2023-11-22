package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThongTinVanChuyenRepo extends JpaRepository<ThongTinVanChuyen,Integer> {
    @Query("SELECT ttvc FROM ThongTinVanChuyen ttvc WHERE ttvc.diaChi LIKE %?1%")
    List<ThongTinVanChuyen> searchByDiaChi(String keyword);
    Optional<ThongTinVanChuyen> findById(Integer integer);
}
