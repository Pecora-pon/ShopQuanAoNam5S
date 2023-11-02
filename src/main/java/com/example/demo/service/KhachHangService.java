package com.example.demo.service;

import com.example.demo.entity.KhachHang;
<<<<<<< HEAD
=======
import com.example.demo.entity.NhanVien;
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

<<<<<<< HEAD
//    KhachHang detail(Integer khachHangId);
//
//    void add(KhachHang khachHang);
//
//    Page<KhachHang> getPage(int pageNumber, int pageSize);
//
//    void delete(Integer khachHangId);
//
//    List<KhachHang> findTenOrDiaChi(String keyword);
=======
    KhachHang detail(Integer khachHangId);

    void add(KhachHang khachHang);

    Page<KhachHang> getPage(int pageNumber, int pageSize);

    void delete(Integer khachHangId);

    List<KhachHang> findTenOrDiaChi(String keyword);
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86

}
