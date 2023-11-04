package com.example.demo.service;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ThongTinVanChuyenService {

    List<ThongTinVanChuyen> getAll();

    ThongTinVanChuyen add(ThongTinVanChuyen thongTinVanChuyen );

    ThongTinVanChuyen update(Integer thongTinVanChuyenID,ThongTinVanChuyen thongTinVanChuyen);

    void delete(Integer thongTinVanChuyenID);

    ThongTinVanChuyen detail(Integer thongTinVanChuyenID);

    Page<ThongTinVanChuyen> getPage(int pageNumber,int pageSize);

    List<ThongTinVanChuyen> findDiaChi(String keyword);
}
