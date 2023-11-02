package com.example.demo.service;

import com.example.demo.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhSachYeuThichService {

    List<DanhSachYeuThich> getAll();

    DanhSachYeuThich detail(Integer DanhSachYTID);
    DanhSachYeuThich update(Integer DanhSachYTID, DanhSachYeuThich danhSachYeuThich);

    void add(DanhSachYeuThich danhSachYeuThich);

    Page<DanhSachYeuThich> getPage(int pageNumber, int pageSize);

    void delete(Integer DanhSachYTID);

    List<DanhSachYeuThich> findKhachHang(String keyword);
}
