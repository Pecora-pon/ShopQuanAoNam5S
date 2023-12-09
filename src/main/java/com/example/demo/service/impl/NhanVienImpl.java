package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienImpl implements NhanVienService {
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepo.getAll();
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        String tendangnhap=nhanVien.getTenDangNhap().trim();
        NhanVien ten=nhanVienRepo.searchByTen(tendangnhap);
        if(ten==null) {
            return null;
        }else {
            return nhanVienRepo.save(nhanVien);
        }
    }

    @Override
    public NhanVien update(Integer nhanVienID, NhanVien nhanVien) {
        NhanVien nhanVien1 = detail(nhanVienID);
        if(nhanVien1 !=null){
            nhanVien1.setNhanVienID(nhanVien.getNhanVienID());
            nhanVien1.setHoTen(nhanVien.getHoTen());
            nhanVien1.setDiaChi(nhanVien.getDiaChi());
            nhanVien1.setEmail(nhanVien.getEmail());
            nhanVien1.setMatKhau(nhanVien.getMatKhau());
            nhanVien1.setSoDienThoai(nhanVien.getSoDienThoai());
            nhanVien1.setTenDangNhap(nhanVien.getTenDangNhap());
            nhanVien1.setTrangThai(nhanVien.getTrangThai());
            nhanVienRepo.save(nhanVien);
        }
        return null;
    }

    @Override
    public void delete(Integer nhanVienID) {
        nhanVienRepo.deleteByI(nhanVienID);

    }

    @Override
    public NhanVien detail(Integer nhanVienID) {
        return nhanVienRepo.findById(nhanVienID).orElse(null);
    }

    @Override
    public Page<NhanVien> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return nhanVienRepo.findByTrangThai(1,pageable);
    }

    @Override
    public List<NhanVien> findTenOrDiaChi(String keyword) {
        return nhanVienRepo.searchByHoTenOrTenDangNhap(keyword);
    }
}
