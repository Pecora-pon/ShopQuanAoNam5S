package com.example.demo.repository;

<<<<<<< HEAD
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewNguoiDungRepo extends JpaRepository<ReviewNguoiDung,Integer> {
    @Query("SELECT n FROM ReviewNguoiDung n WHERE n.khachHang LIKE %?1%")
    List<ReviewNguoiDung> searchByKhachHang(String keyword);

=======
import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewNguoiDungRepo extends JpaRepository<ReviewNguoiDung,Integer> {
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
}
