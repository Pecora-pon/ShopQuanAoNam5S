package com.example.demo.service.impl;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.NhapKho;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.NhaCungCapRepository;
import com.example.demo.repository.NhapKhoRepository;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.NhaCungCapService;
import com.example.demo.service.NhapKhoService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class NhapKhoServiceImpl implements NhapKhoService {
    @Autowired
    NhapKhoRepository nhapKhoRepository;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Override
    public List<NhapKho> getAll() {
        return nhapKhoRepository.getAl();
    }

    @Override
    public Respon<NhapKho> add(NhapKho nhapKho) {
        Respon<NhapKho> respon=new Respon<>();
        if(nhapKho.getMauSac() !=null || nhapKho.getChatLieu() !=null||nhapKho.getNhaCungCap() !=null||nhapKho.getSize() != null){
            if(isInteger(nhapKho.getSoLuongNhap())){
               UUID sp=nhapKho.getSanPham().getSanPhamID();
//                SanPham sanPham=sanPhamRepo.findById(sp).orElse(null);
                int sl=nhapKho.getSoLuongNhap();
                nhapKho.setNgayNhap(LocalDate.now());
                nhapKhoRepository.save(nhapKho);
                sanPhamService.capnhat(sp,sl);
                respon.setStatus("Thành công");
            }else {
                respon.setError("Số lượng nhập phải là số");
            }

        }else {
            respon.setError("Không được để trống");
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
    public Respon<NhapKho> update(Integer nhaKhoID, NhapKho nhapKho) {
       Respon<NhapKho> respon=new Respon<>();
        NhapKho nhapKho1=detail(nhaKhoID);
        if(nhapKho1 !=null){
            nhapKho1.setNhapKhoID(nhapKho.getNhapKhoID());
            nhapKho1.setNgayNhap(nhapKho.getNgayNhap());
            nhapKho1.setSoLuongNhap(nhapKho.getSoLuongNhap());
            nhapKho1.setChatLieu(nhapKho.getChatLieu());
            nhapKho1.setNhaCungCap(nhapKho.getNhaCungCap());
            nhapKho1.setMauSac(nhapKho.getMauSac());
            nhapKho1.setSize(nhapKho.getSize());
            nhapKhoRepository.save(nhapKho1);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer nhapKhoID) {
     nhapKhoRepository.deleteByI(nhapKhoID);
    }

    @Override
    public NhapKho detail(Integer nhapKhoID) {
        return nhapKhoRepository.findById(nhapKhoID).orElse(null);
    }

    @Override
    public Page<NhapKho> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return nhapKhoRepository.findByTrangThai(0,pageable);
    }

    @Override
    public List<NhapKho> findSize(Integer size) {
        return nhapKhoRepository.findBySize(size);
    }

    @Override
    public List<NhapKho> findMauSac(Integer mauSac) {
        return nhapKhoRepository.findByMauSac(mauSac);
    }

    @Override
    public List<NhapKho> findNhaCC(Integer nhaCungCap) {
        return nhapKhoRepository.findByNhaCC(nhaCungCap);
    }

    @Override
    public List<NhapKho> findChatLieu(Integer chatLieu) {
        return nhapKhoRepository.findByChatLieu(chatLieu);
    }

//    @Override
//    public NhapKho themmoi(NhapKho nhapKho, List<UUID> sanPhamList) {
//        for(UUID sanpham: sanPhamList){
//            SanPham sanPham=sanPhamRepo.findById(sanpham).orElse(null);
//            NhapKho nhapKho1=new NhapKho();
//            nhapKho1.setSoLuongNhap(nhapKho.getSoLuongNhap());
//            nhapKho1.setTrangThai(0);
//            nhapKho1.setSize(nhapKho.getSize());
//            nhapKho1.setMauSac(nhapKho.getMauSac());
//            nhapKho1.setNhaCungCap(nhapKho.getNhaCungCap());
//            nhapKho1.setChatLieu(nhapKho.getChatLieu());
//            nhapKho1.setNgayNhap(LocalDate.now());
//            nhapKho1.setSanPham(sanPham);
//            nhapKhoRepository.save(nhapKho1);
//            sanPhamService.capnhat(sanpham,-nhapKho1.getSoLuongNhap());
//        }
//        return null;
//    }
}
