package com.example.demo.service.impl;

import com.example.demo.entity.GiamGiaChiTiet;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.GiamGiaChiTietRepository;
import com.example.demo.service.GiamGiaChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiamGiaChiTietServiceImpl implements GiamGiaChiTietService {
    @Autowired
    private GiamGiaChiTietRepository giamGiaChiTietRepo;
    @Override
    public List<GiamGiaChiTiet> getAll() {
        return giamGiaChiTietRepo.findAll();
    }

    @Override
    public Respon<GiamGiaChiTiet> add(GiamGiaChiTiet giamGiaChiTiet) {
        Respon<GiamGiaChiTiet> respon = new Respon<>();
        if(giamGiaChiTiet.getSoTienGiam() != null &&
            giamGiaChiTiet.getGiamGia() != null &&
            giamGiaChiTiet.getSanPham()!= null){
            giamGiaChiTietRepo.save(giamGiaChiTiet);
            respon.setStatus("Thành công");
        }else{
            respon.setError("Vui lòng nhập đầy đủ");
        }
        return respon;
    }

    @Override
    public Respon<GiamGiaChiTiet> update(Integer giamGiaChiTietID, GiamGiaChiTiet giamGiaChiTiet) {
        Respon<GiamGiaChiTiet> respon = new Respon<>();
        GiamGiaChiTiet giamGiaChiTiet1 = detail(giamGiaChiTietID);
        if(giamGiaChiTiet1!=null){
            giamGiaChiTiet1.setGiamGiaChiTietID(giamGiaChiTiet.getGiamGiaChiTietID());
            giamGiaChiTiet1.setSoTienGiam(giamGiaChiTiet.getSoTienGiam());
            giamGiaChiTiet1.setGiamGia(giamGiaChiTiet.getGiamGia());
            giamGiaChiTiet1.setSanPham(giamGiaChiTiet.getSanPham());
            giamGiaChiTietRepo.save(giamGiaChiTiet);
            respon.setStatus("Thành công");
        }else{
            respon.setError("Vui lòng nhập đầy đủ");
        }
        return respon;
    }

    @Override
    public void delete(Integer giamGiaChiTietID) {
        giamGiaChiTietRepo.deleteById(giamGiaChiTietID);
    }

    @Override
    public GiamGiaChiTiet detail(Integer giamGiaChiTietID) {
        return giamGiaChiTietRepo.findById(giamGiaChiTietID).orElse(null);
    }

    @Override
    public Page<GiamGiaChiTiet> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return giamGiaChiTietRepo.findAll(pageable);
    }

    @Override
    public List<GiamGiaChiTiet> findTenSanPham(String keyword) {
        return giamGiaChiTietRepo.searchBytenSanPham(keyword);
    }


}
