package com.example.demo.repository;

import com.example.demo.entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,Integer> {
    @Query("Select n from NhaCungCap n Where n.tenNhaCungCap like :keyword or n.email like :keyword or n.diaChi like :keyword ")
    List<NhaCungCap> searchBy(@Param("keyword")String keyword);
    @Query("Select n from NhaCungCap n order by n.nhaCungCapID desc ")
    List<NhaCungCap> getAl();
}
