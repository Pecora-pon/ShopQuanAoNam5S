package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ThuongHieuService {
    List<ThuongHieu> getAll();

   Respon<ThuongHieu>  add(ThuongHieu thuongHieu);

    Respon<ThuongHieu> update(Integer thuongHieuID, ThuongHieu thuongHieu);

    void delete(Integer thuongHieuID);

    ThuongHieu detail(Integer thuongHieuID);
    List<ThuongHieu> findTen(String keyword);
    Page<ThuongHieu> getPage(int pageNumber,int pageSize);
}
