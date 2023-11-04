package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.repository.ThongTinVanChuyenRepo;
import com.example.demo.service.ThongTinVanChuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThongTinVanChuyenServiceImpl implements ThongTinVanChuyenService {
    @Autowired
    private ThongTinVanChuyenRepo thongTinVanChuyenRepo;

    @Override
    public List<ThongTinVanChuyen> getAll() {
        return thongTinVanChuyenRepo.findAll();
    }

    @Override
    public ThongTinVanChuyen add(ThongTinVanChuyen thongTinVanChuyen) {
        return thongTinVanChuyenRepo.save(thongTinVanChuyen);
    }

    @Override
    public ThongTinVanChuyen update(Integer thongTinVanChuyenID, ThongTinVanChuyen thongTinVanChuyen) {
        ThongTinVanChuyen thongTinVanChuyen1 = detail(thongTinVanChuyenID);
        if(thongTinVanChuyen1 !=null){
            thongTinVanChuyen1.setThongTinVanChuyenID(thongTinVanChuyen.getThongTinVanChuyenID());
            thongTinVanChuyen1.setDiaChi(thongTinVanChuyen.getDiaChi());
            thongTinVanChuyen1.setPhuongThuc(thongTinVanChuyen.getPhuongThuc());
            thongTinVanChuyen1.setTrangThai(thongTinVanChuyen.getTrangThai());
            thongTinVanChuyenRepo.save(thongTinVanChuyen);
        }
        return null;
    }

    @Override
    public void delete(Integer thongTinVanChuyenID) {
            thongTinVanChuyenRepo.deleteById(thongTinVanChuyenID);
    }

    @Override
    public ThongTinVanChuyen detail(Integer thongTinVanChuyenID) {
        return thongTinVanChuyenRepo.findById(thongTinVanChuyenID).orElse(null);
    }

    @Override
    public Page<ThongTinVanChuyen> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return thongTinVanChuyenRepo.findAll(pageable);
    }

    @Override
    public List<ThongTinVanChuyen> findDiaChi(String keyword) {
        return thongTinVanChuyenRepo.searchByDiaChi(keyword);
    }


}
