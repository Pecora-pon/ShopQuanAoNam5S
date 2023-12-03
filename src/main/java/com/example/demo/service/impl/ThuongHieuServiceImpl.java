package com.example.demo.service.impl;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.ThuongHieuRepo;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
@Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepo.getAl();
    }

    @Override
    public Respon<ThuongHieu> add(ThuongHieu thuongHieu) {
        Respon<ThuongHieu> respon=new Respon<>();
        String tenThuongHieu=thuongHieu.getTenThuongHieu().trim();
        ThuongHieu ten=thuongHieuRepo.searchByten(tenThuongHieu);
        if(ten==null){
            respon.setError("Tên đã tồn tại");
        }else {
            if (thuongHieu.getTenThuongHieu() != null && !thuongHieu.getTenThuongHieu().isEmpty()) {
                thuongHieu.setTenThuongHieu(tenThuongHieu);
                thuongHieu.setTrangThai(0);
                thuongHieuRepo.save(thuongHieu);
                respon.setStatus("Thành công");
            } else {
                respon.setError("Tên đang bị sai");
            }
        }
        return respon;
    }

    @Override
    public Respon<ThuongHieu> update(Integer thuongHieuID, ThuongHieu thuongHieu) {
        Respon<ThuongHieu>respon=new Respon<>();
        ThuongHieu thuongHieu1=detail(thuongHieuID);
        if(thuongHieu1 !=null){
            thuongHieu1.setThuongHieuID(thuongHieu.getThuongHieuID());
            thuongHieu1.setTenThuongHieu(thuongHieu.getTenThuongHieu());
            thuongHieuRepo.save(thuongHieu);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer thuongHieuID) {
    thuongHieuRepo.deleteById(thuongHieuID);
    }

    @Override
    public ThuongHieu detail(Integer thuongHieuID) {
        return thuongHieuRepo.findById(thuongHieuID).orElse(null);
    }

    @Override
    public List<ThuongHieu> findTen(String keyword) {
        return thuongHieuRepo.searchBy(keyword);
    }

    @Override
    public Page<ThuongHieu> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return thuongHieuRepo.findAll(pageable);
    }
}
