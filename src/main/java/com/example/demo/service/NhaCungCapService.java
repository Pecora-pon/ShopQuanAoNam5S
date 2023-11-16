package com.example.demo.service;


import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhaCungCapService {
    List<NhaCungCap> getAll();

   Respon<NhaCungCap>  add(NhaCungCap nhaCungCap);

   Respon<NhaCungCap>  update(Integer Id, NhaCungCap nhaCungCap);

    void delete(Integer Id);

    NhaCungCap detail(Integer Id);

    List<NhaCungCap> findby(String keyword);

    Page<NhaCungCap> getPage(int pageNumber,int pageSize);
}
