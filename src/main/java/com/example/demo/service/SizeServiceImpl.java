package com.example.demo.service.impl;


import com.example.demo.entity.SanPham;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.SizeRepo;
import com.example.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {
  @Autowired
    SizeRepo sizeRepo;

    @Override
    public List<Size> getAll() {
        return sizeRepo.getAll();
    }
    @Override
    public Respon<Size> add(Size size) {
        Respon<Size> respon = new Respon<>();
        String tenSize = size.getTenSize().trim();

        if (size.getTenSize() != null && !size.getTenSize().isEmpty()) {
            Size tensi=sizeRepo.searchByten(tenSize);
            if (tensi !=null) {
                tensi.setSoLuong(tensi.getSoLuong() + size.getSoLuong());
                sizeRepo.save(tensi);
                respon.setStatus("Cập nhật số lượng thành công");
            } else {
                // Check if tenSize contains only alphanumeric characters
                if (isAlphanumeric(tenSize)) {
                    size.setTenSize(tenSize);
                    size.setTrangThai(0);
                    sizeRepo.save(size);
                    respon.setStatus("Thành công");
                } else {
                    respon.setError("Tên chỉ được chứa chữ cái và số");
                }
            }
        } else {
            respon.setError("Tên không đúng");
        }

        return respon;
    }

    private boolean isAlphanumeric(String input) {
        // Check if the input contains only alphanumeric characters
        return input.matches("^[a-zA-Z0-9]+$");
    }
    @Override
    public Respon<Size> update(Integer sizeID, Size size) {
        Respon<Size>respon=new Respon<>();
        Size size1=detail(sizeID);
        if(size1 != null){
            if(isAlphanumeric(size.getTenSize())) {
                size1.setSizeID(size.getSizeID());
                size1.setTenSize(size.getTenSize());
                size1.setSoLuong(size.getSoLuong());
                sizeRepo.save(size);
                respon.setStatus("thành công");
            }else {
                respon.setError("Không đúng định dạng");
            }
        }else {
            respon.setError("Không thành công");
        }
        return null;
    }

    @Override
    public void delete(Integer sizeID) {
 sizeRepo.deleteByI(sizeID);
    }

    @Override
    public Size detail(Integer sizeID) {
        return sizeRepo.findById(sizeID).orElse(null);
    }

    @Override
    public List<Size> findSize(String keyword) {
        return sizeRepo.searchBy(keyword);
    }

    @Override
    public Page<Size> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return sizeRepo.findByTrangThai(0,pageable);
    }

//    @Override
//    public Page<Size> page(int page) {
//        Pageable pageable=PageRequest.of(page,2);
//        return sizeRepo.findAll(pageable);
//    }

    @Override
    public void capnhat(int id, int soluong) {
        Size size=sizeRepo.findById(id).orElse(null);

        if (size != null) {
            int soluongmoi = size.getSoLuong() - soluong;
            if (soluongmoi >= 0) {
                size.setSoLuong(soluongmoi);
                sizeRepo.save(size);
            } else {
                throw new IllegalArgumentException("Số lượng trong sản phẩm không đủ");
            }
        }
    }
}
