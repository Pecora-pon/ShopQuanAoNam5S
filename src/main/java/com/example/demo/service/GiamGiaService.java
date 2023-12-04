package com.example.demo.service;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GiamGiaService {
    List<GiamGia> getAll();

    Respon<GiamGia> add(GiamGia giamGia);

    Respon<GiamGia> update(Integer giamGiaID,GiamGia giamGia);

    void delete(Integer giamGiaID);

    GiamGia detail(Integer giamGiaID);

    Page<GiamGia> getPage(int pageNumber,int pageSize);

    List<GiamGia> findMaGiamGia(String keyword);


}
