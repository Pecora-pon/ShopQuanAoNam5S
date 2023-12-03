package com.example.demo.service.impl;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.NhaCungCapRepository;
import com.example.demo.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
@Autowired
    NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapRepository.getAl();
    }

    @Override
    public Respon<NhaCungCap> add(NhaCungCap nhaCungCap) {
        Respon<NhaCungCap> respon = new Respon<>();

        // Kiểm tra xem các trường tên, email và địa chỉ không được để trống
        if (nhaCungCap.getTenNhaCungCap() != null && !nhaCungCap.getTenNhaCungCap().isEmpty() &&
                nhaCungCap.getEmail() != null && !nhaCungCap.getEmail().isEmpty() &&
                nhaCungCap.getDiaChi() != null && !nhaCungCap.getDiaChi().isEmpty()) {

            String tenNhaCungCap = nhaCungCap.getTenNhaCungCap().trim();
            String email = nhaCungCap.getEmail().trim();
            String diaChi = nhaCungCap.getDiaChi().trim();

            // Kiểm tra xem tên nhà cung cấp không chứa chữ số
            if (!containsDigits(tenNhaCungCap)) {

                // Kiểm tra định dạng email
                if (isValidEmail(email)) {
                    nhaCungCap.setTenNhaCungCap(tenNhaCungCap);
                    nhaCungCap.setEmail(email);
                    nhaCungCap.setDiaChi(diaChi);
                    nhaCungCap.setTrangThai(0);
                    nhaCungCapRepository.save(nhaCungCap);
                    respon.setStatus("Thành công");
                } else {
                    respon.setError("Email không hợp lệ.");
                }
            } else {
                respon.setError("Tên nhà cung cấp không được chứa chữ số.");
            }
        } else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    // Hàm kiểm tra xem một chuỗi có chứa chữ số hay không
    private boolean containsDigits(String str) {
        return Pattern.compile("\\d").matcher(str).find();
    }

    // Hàm kiểm tra định dạng email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Override
    public Respon<NhaCungCap> update(Integer Id, NhaCungCap nhaCungCap) {
       Respon<NhaCungCap>respon=new Respon<>();
        NhaCungCap nhaCungCap1=detail(Id);
        if(nhaCungCap1 !=null){
            nhaCungCap1.setNhaCungCapID(nhaCungCap.getNhaCungCapID());
            nhaCungCap1.setTenNhaCungCap(nhaCungCap.getTenNhaCungCap());
            nhaCungCap1.setDiaChi(nhaCungCap.getDiaChi());
            nhaCungCap1.setEmail(nhaCungCap.getEmail());
            nhaCungCap1.setSdt(nhaCungCap.getSdt());
            nhaCungCapRepository.save(nhaCungCap);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer Id) {
    nhaCungCapRepository.deleteByI(Id);
    }

    @Override
    public NhaCungCap detail(Integer Id) {
        return nhaCungCapRepository.findById(Id).orElse(null);
    }

    @Override
    public List<NhaCungCap> findby(String keyword) {
        return nhaCungCapRepository.searchBy(keyword);
    }

    @Override
    public Page<NhaCungCap> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return nhaCungCapRepository.findAll(pageable);
    }
}
