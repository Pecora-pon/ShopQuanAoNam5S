package com.example.demo.service;


import com.example.demo.entity.NhapKho;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NhapKhoService {
    List<NhapKho> getAll();

   Respon<NhapKho>  add(NhapKho nhapKho);

   Respon<NhapKho>  update(Integer nhaKhoID, NhapKho nhapKho);

    void delete(Integer nhapKhoID);

    NhapKho detail(Integer nhapKhoID);
    Page<NhapKho> getPage(int pageNumber,int pageSize);
    List<NhapKho> findSize(Integer size);
    List<NhapKho>findMauSac(Integer mauSac);
    List<NhapKho>findNhaCC(Integer nhaCungCap);
    List<NhapKho> findChatLieu(Integer chatLieu);
    NhapKho themmoi(NhapKho nhapKho, List<UUID> sanPhamList);
}
