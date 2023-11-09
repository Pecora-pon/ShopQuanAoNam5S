package com.example.demo.service;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.GiamGiaChiTiet;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.GiamGiaChiTietRepository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GiamGiaChiTietService {
    List<GiamGiaChiTiet> getAll();

    Respon<GiamGiaChiTiet> add(GiamGiaChiTiet giamGiaChiTiet);

    Respon<GiamGiaChiTiet> update(Integer giamGiaChiTietID,GiamGiaChiTiet giamGiaChiTiet);

    void delete(Integer giamGiaChiTietID);

    GiamGiaChiTiet detail(Integer giamGiaChiTietID);

    Page<GiamGiaChiTiet> getPage(int pageNumber, int pageSize);

    List<GiamGiaChiTiet> findTenSanPham(String keyword);

}
