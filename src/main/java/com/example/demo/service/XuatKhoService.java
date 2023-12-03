package com.example.demo.service;

import com.example.demo.entity.NhapKho;
import com.example.demo.entity.XuatKho;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface XuatKhoService {
    List<XuatKho> getAll();

   Respon<XuatKho>  add(XuatKho xuatKho);

    Respon<XuatKho> update(Integer xuatKhoID, XuatKho xuatKho);

    void delete(Integer xuatKhoID);
     Page<XuatKho> getPage(int pageNumber,int pageSize);

    XuatKho detail(Integer xuatKhoID);
    List<XuatKho> findSize(Integer size);
    List<XuatKho>findMauSac(Integer mauSac);
    List<XuatKho>findNhaCC(Integer nhaCungCap);
    List<XuatKho> findChatLieu(Integer chatLieu);
    XuatKho them(XuatKho xuatKho, List<UUID> sanPhamList);
}
