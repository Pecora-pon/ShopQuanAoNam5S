package com.example.demo.service.impl;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.ThongTinVanChuyenRepo;
import com.example.demo.service.ThongTinVanChuyenService;
import jakarta.servlet.http.HttpServletRequest;
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
        return thongTinVanChuyenRepo.getAll();
    }

    @Override
    public Respon<ThongTinVanChuyen> add(ThongTinVanChuyen thongTinVanChuyen) {

        Respon<ThongTinVanChuyen> respon=new Respon<>();

        if( !thongTinVanChuyen.getDiaChi().isEmpty()

        ){
            thongTinVanChuyen.setPhuongThuc("Vận chuyển nhanh");
            thongTinVanChuyen.setTrangThai(0);
            thongTinVanChuyenRepo.save(thongTinVanChuyen);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Vui lòng nhập đầy đủ dữ liệu");
        }
        return respon;
    }


    @Override
    public Respon<ThongTinVanChuyen> update(Integer thongTinVanChuyenID, ThongTinVanChuyen thongTinVanChuyen) {
        Respon<ThongTinVanChuyen>  respon = new Respon<>();
        ThongTinVanChuyen thongTinVanChuyen1 = detail(thongTinVanChuyenID);
        if(thongTinVanChuyen1 !=null){
            thongTinVanChuyen1.setThongTinVanChuyenID(thongTinVanChuyen.getThongTinVanChuyenID());
            thongTinVanChuyen1.setDiaChi(thongTinVanChuyen.getDiaChi());
            thongTinVanChuyen1.setPhuongThuc(thongTinVanChuyen.getPhuongThuc());
            thongTinVanChuyen1.setTrangThai(thongTinVanChuyen.getTrangThai());
            thongTinVanChuyenRepo.save(thongTinVanChuyen);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Vui lòng nhập đầy đủ dữ liệu");
        }
        return respon;
    }

    @Override
    public void delete(Integer thongTinVanChuyenID) {
            thongTinVanChuyenRepo.deleteByI(thongTinVanChuyenID);
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

    @Override
    public List<ThongTinVanChuyen> getAllByKhachHang(String username) {
        return thongTinVanChuyenRepo.findByKhachHang_Username(username);
    }


}
