package com.example.demo.service;

import com.example.demo.entity.DanhSachSanPhamYeuThich;
import com.example.demo.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DanhSachYeuThichService {

    List<DanhSachYeuThich> getAll();
    List<DanhSachSanPhamYeuThich> getAlll();

    DanhSachYeuThich detail(Integer DanhSachYTID);
    DanhSachYeuThich update(Integer DanhSachYTID, DanhSachYeuThich danhSachYeuThich);

    void add(DanhSachYeuThich danhSachYeuThich);

    Page<DanhSachYeuThich> getPage(int pageNumber, int pageSize);

    void delete(Integer DanhSachYTID);

    List<DanhSachYeuThich> findKhachHang(String keyword);

    DanhSachYeuThich them(DanhSachYeuThich danhSachYeuThich, UUID sanPhamID);

    List<DanhSachSanPhamYeuThich> findKhachHang_name(String name);
}
