package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();

   Respon<MauSac>  add(MauSac mauSac);

   Respon<MauSac>  update(Integer mauSacID, MauSac mauSac);

    void delete(Integer mauSacID);

    MauSac detail(Integer mauSacID);

    List<MauSac> findTen(String keyword);
    Page<MauSac> getPage(int pageNumber,int pageSize);
}
