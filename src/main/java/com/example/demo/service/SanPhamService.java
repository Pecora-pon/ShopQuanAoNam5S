package com.example.demo.service;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.NhapKho;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    Respon<SanPham> add(SanPham sanPham);

   Respon<SanPham> update(UUID sanPhamID, SanPham sanPham);

    void delete(UUID sanPhamID);

    SanPham detail(UUID sanPhamID);
    Page<SanPham> getPage(int pageNumber, int pageSize);
    void capnhat(UUID id,int soluong);
    SanPham size(SanPham sanPham,UUID sanPhamID);
//   SanPham themgio(UUID sanPhamID);
}
