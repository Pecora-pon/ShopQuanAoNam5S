package com.example.demo.service.impl;

import com.example.demo.entity.NhapKho;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.XuatKho;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.repository.XuatKhoRepository;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.XuatKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class XuatKhoServiceImpl implements XuatKhoService {
    @Autowired
    XuatKhoRepository xuatKhoRepository;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Override
    public List<XuatKho> getAll() {
        return xuatKhoRepository.getAl();
    }

    @Override
    public Respon<XuatKho> add(XuatKho xuatKho) {
        Respon<XuatKho> respon=new Respon<>();
        if(xuatKho.getChatLieu()!=null||xuatKho.getMauSac()!=null||xuatKho.getSize()!=null||xuatKho.getNhaCungCap()!=null){
           if(isInteger(xuatKho.getSoLuongXuat())) {
               UUID sp=xuatKho.getSanPham().getSanPhamID();
               int sl=xuatKho.getSoLuongXuat();
               xuatKho.setNgayXuat(LocalDate.now());
               xuatKho.setTrangThai(0);
               xuatKhoRepository.save(xuatKho);
               sanPhamService.capnhat(sp,-sl);
               respon.setStatus("Thành công");
           }else {
               respon.setError("Số lượng ko được nhập chữ");
           }
        }else {
            respon.setError("không được để trống");
        }
        return respon;
    }
private boolean isInteger(int str){
        try{
            Integer.parseInt(String.valueOf(str));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
}
    @Override
    public Respon<XuatKho> update(Integer xuatKhoID, XuatKho xuatKho) {
      Respon<XuatKho>respon=new Respon<>();
        XuatKho xuatKho1=detail(xuatKhoID);
        if(xuatKho1 !=null){
            xuatKho1.setXuatKhoID(xuatKho.getXuatKhoID());
            xuatKho1.setNgayXuat(xuatKho.getNgayXuat());
            xuatKho1.setSoLuongXuat(xuatKho.getSoLuongXuat());
            xuatKho1.setChatLieu(xuatKho.getChatLieu());
            xuatKho1.setNhaCungCap(xuatKho.getNhaCungCap());
            xuatKho1.setMauSac(xuatKho.getMauSac());
            xuatKho1.setSize(xuatKho.getSize());
            xuatKhoRepository.save(xuatKho1);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer xuatKhoID) {
      xuatKhoRepository.deleteByI(xuatKhoID);
    }

    @Override
    public Page<XuatKho> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return xuatKhoRepository.findAll(pageable);
    }

    @Override
    public XuatKho detail(Integer xuatKhoID) {
        return null;
    }

    @Override
    public List<XuatKho> findSize(Integer size) {
        return xuatKhoRepository.findBySize(size);
    }

    @Override
    public List<XuatKho> findMauSac(Integer mauSac) {
        return xuatKhoRepository.findByMauSac(mauSac);
    }

    @Override
    public List<XuatKho> findNhaCC(Integer nhaCungCap) {
        return xuatKhoRepository.findByNhaCC(nhaCungCap);
    }

    @Override
    public List<XuatKho> findChatLieu(Integer chatLieu) {
        return xuatKhoRepository.findByChatLieu(chatLieu);
    }
    @Override
    public XuatKho them(XuatKho xuatKho, List<UUID> sanPhamList) {
        for(UUID sanpham:sanPhamList){
            SanPham sanPham=sanPhamRepo.findById(sanpham).orElse(null);
            XuatKho xuatKho1=new XuatKho();
            xuatKho1.setSanPham(sanPham);
            xuatKho1.setSoLuongXuat(xuatKho.getSoLuongXuat());
            xuatKho1.setNgayXuat(LocalDate.now());
            xuatKho1.setChatLieu(xuatKho.getChatLieu());
            xuatKho1.setMauSac(xuatKho.getMauSac());
            xuatKho1.setSize(xuatKho.getSize());
            xuatKho1.setNhaCungCap(xuatKho.getNhaCungCap());
            xuatKhoRepository.save(xuatKho1);
            sanPhamService.capnhat(sanpham,xuatKho1.getSoLuongXuat());
        }
        return null;
    }
}
