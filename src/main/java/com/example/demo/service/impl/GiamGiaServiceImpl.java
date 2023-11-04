package com.example.demo.service.impl;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.GiamGiaRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GiamGiaServiceImpl implements GiamGiaService {
    @Autowired
    private GiamGiaRepo giamGiaRepo;
    @Autowired
    private NhanVienRepo nhanVienRepo;


    @Override
    public List<GiamGia> getAll() {
        return giamGiaRepo.findAll();
    }

    @Override
    public GiamGia add(GiamGia giamGia) {

        return giamGiaRepo.save(giamGia);
    }

    @Override
    public GiamGia update(Integer giamGiaID, GiamGia giamGia) {
        GiamGia giamGia1 = detail(giamGiaID);
        if(giamGia1 !=null){
            giamGia1.setGiamGiaID(giamGia.getGiamGiaID());
            giamGia1.setMaGiamGia(giamGia.getMaGiamGia());
            giamGia1.setTenSuKien(giamGia.getTenSuKien());
            giamGia1.setNhanVien(giamGia.getNhanVien());
            giamGia1.setNgayTao(giamGia.getNgayTao());
            giamGia1.setNgayHetHan(giamGia.getNgayHetHan());
            giamGiaRepo.save(giamGia);
        }
        return null;
    }

    @Override
    public void delete(Integer giamGiaID) {
            giamGiaRepo.deleteById(giamGiaID);
    }

    @Override
    public GiamGia detail(Integer giamGiaID) {
        return giamGiaRepo.findById(giamGiaID).orElse(null);
    }

    @Override
    public Page<GiamGia> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return giamGiaRepo.findAll(pageable);
    }

    @Override
    public List<GiamGia> findMaGiamGia(String keyword) {
        return giamGiaRepo.searchBymaGiamGia(keyword);
    }
}
