package com.example.demo.service.impl;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.repository.DanhSachYeuThichRepo;
import com.example.demo.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DanhSachYeuThichServiceImpl implements DanhSachYeuThichService {

    @Autowired
    private DanhSachYeuThichRepo repo;


    @Override
    public List<DanhSachYeuThich> getAll() {
        return repo.findAll();
    }

    @Override
    public DanhSachYeuThich detail(Integer DanhSachYTID) {
        return repo.findById(DanhSachYTID).orElse(null);
    }

    @Override
    public DanhSachYeuThich update(Integer DanhSachYTID, DanhSachYeuThich danhSachYeuThich) {
//        DanhSachYeuThich danhSachYeuThich1 = detail(DanhSachYTID);
//        if (danhSachYeuThich1 !=null){
//            danhSachYeuThich1.setDanhSachYeuThichID(danhSachYeuThich.getDanhSachYeuThichID());
//            danhSachYeuThich1.setKhachHang(danhSachYeuThich.getKhachHang().getHoTen());
//            repo.save(danhSachYeuThich);
//        }
        return null;
    }

    @Override
    public void add(DanhSachYeuThich danhSachYeuThich) {
            repo.save(danhSachYeuThich);
    }

    @Override
    public Page<DanhSachYeuThich> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repo.findAll(pageable);
    }

    @Override
    public void delete(Integer DanhSachYTID) {
        repo.deleteById(DanhSachYTID);
    }

    @Override
    public List<DanhSachYeuThich> findKhachHang(String keyword) {
        return null;
    }

//    @Override
//    public List<DanhSachYeuThich> findKhachHang(String keyword) {
//        return repo.searchByKhachHang(keyword);
//    }
}
