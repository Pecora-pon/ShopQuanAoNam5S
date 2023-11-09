package com.example.demo.service;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ThongTinVanChuyenService {

    List<ThongTinVanChuyen> getAll();

    Respon<ThongTinVanChuyen> add(ThongTinVanChuyen thongTinVanChuyen );

    Respon<ThongTinVanChuyen> update(Integer thongTinVanChuyenID,ThongTinVanChuyen thongTinVanChuyen);

    void delete(Integer thongTinVanChuyenID);

    ThongTinVanChuyen detail(Integer thongTinVanChuyenID);

    Page<ThongTinVanChuyen> getPage(int pageNumber,int pageSize);

    List<ThongTinVanChuyen> findDiaChi(String keyword);
}
