package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien add(NhanVien nhanVien);

    NhanVien update(Integer nhanVienID,NhanVien nhanVien);

    void delete(Integer nhanVienID);

    NhanVien detail(Integer nhanVienID);

    Page<NhanVien> getPage(int pageNumber,int pageSize);

    List<NhanVien> findTenOrDiaChi(String keyword);
}
