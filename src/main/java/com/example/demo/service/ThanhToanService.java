package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ThanhToanService {
    List<GioHang> detail(List<Integer> gioHangID, Map<String, String> params);
    SanPham deltail1(UUID sanPham,int sl);
//    KhachHang kh(String ten);
   DonHang themmoi(DonHang donHang,List<Integer> danhSachGioHangs,float tt);
    DonHang themmoingay(DonHang donHang,UUID sanPham,int sl,float tt);

}
