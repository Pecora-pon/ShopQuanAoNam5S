package com.example.demo.repository;

import com.example.demo.entity.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamGiaRepo extends JpaRepository<GiamGia,Integer> {
}
