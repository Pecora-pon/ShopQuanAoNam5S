package com.example.demo.repository;

import com.example.demo.entity.ThongTinVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinVanChuyenRepo extends JpaRepository<ThongTinVanChuyen,Integer> {
}
