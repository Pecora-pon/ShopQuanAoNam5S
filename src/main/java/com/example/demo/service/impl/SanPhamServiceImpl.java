package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.*;
import com.example.demo.service.MauSacService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Autowired
    SizeService sizeService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    MauSacRepo mauSacRepo;
    @Autowired
    SizeRepo sizeRepo;
    @Autowired
    ChatLieuRepository chatLieuRepository;
    @Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepo.getAll();
    }

    @Override
    public Respon<SanPham> add(SanPham sanPham) {
        Respon<SanPham> respon = new Respon<>();

        // Kiểm tra giá sản phẩm phải khác null và là số
        if (sanPham.getGiaSanPham() != null &&
                isNumeric1(String.valueOf(sanPham.getGiaSanPham())) &&

                // Kiểm tra tất cả các trường bắt buộc không được để trống
                sanPham.getTenSanPham() != null && !sanPham.getTenSanPham().trim().isEmpty() &&
                sanPham.getMoTa() != null && !sanPham.getMoTa().trim().isEmpty() &&
                sanPham.getSize() != null &&
                sanPham.getChatLieu() != null &&
                sanPham.getMauSac() != null &&
                sanPham.getThuongHieu() != null &&
                sanPham.getHinhAnhURL() != null &&
                // Kiểm tra số lượng tồn phải khác null và là số
                sanPham.getSoLuongTon() != null && isNumeric(String.valueOf(sanPham.getSoLuongTon()))) {

            // Check if any field contains only spaces
            if (containsOnlySpaces(sanPham)) {
                respon.setError("Không được nhập nguyên dấu cách ở mỗi trường");
            } else {
                String tensp = sanPham.getTenSanPham();
                int tenms = sanPham.getMauSac().getMauSacID();
                int tensi = sanPham.getSize().getSizeID();
                int tentt = sanPham.getThuongHieu().getThuongHieuID();
                int tencl = sanPham.getChatLieu().getChatLieuID();
                SanPham sp = sanPhamRepo.findByTenAndAttributes(tensp, tenms, tensi, tencl, tentt);

                if (sp != null) {
                    sp.setSoLuongTon(sp.getSoLuongTon() + sanPham.getSoLuongTon());
                    sanPhamRepo.save(sp);
                    respon.setStatus("Cập nhật số lượng thành công.");


                } else {
                    sanPham.setNgayTao(LocalDate.now());
                    sanPham.setTinhTrang(0);
                    try {
                        sizeService.capnhat(sanPham.getSize().getSizeID(), sanPham.getSoLuongTon());
                        mauSacService.capnhat(sanPham.getMauSac().getMauSacID(), sanPham.getSoLuongTon());
                        sanPhamRepo.save(sanPham);
                        respon.setStatus("Thành công");
                    } catch (IllegalArgumentException e) {
                        respon.setError("Không đủ số lượng trong size hoặc mauSac.");
                    }
                }
            }
        } else {
            respon.setError("Không được để trống các trường bắt buộc, và giá sản phẩm phải là số");
        }

        return respon;
    }

    private boolean containsOnlySpaces(SanPham sanPham) {
        // Check if any field contains only spaces
        return sanPham.getTenSanPham().trim().matches("^\\s*$") ||
                sanPham.getMoTa().trim().matches("^\\s*$");

    }

    // Phương thức kiểm tra xem một chuỗi có phải là số không
    private boolean isNumeric1(String str) {
        try {
            Double.parseDouble(str); // Sử dụng Double để hỗ trợ số thập phân
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Phương thức kiểm tra xem một chuỗi có phải là số nguyên không
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public Respon<SanPham> update(UUID sanPhamID, SanPham sanPham) {
        Respon<SanPham> respon = new Respon<>();
        SanPham sanPham1 = detail(sanPhamID);

        if (sanPham1 != null) {
            // Kiểm tra và cập nhật giá trị nếu khác null
            if (sanPham.getGiaSanPham() != null) {
                sanPham1.setGiaSanPham(sanPham.getGiaSanPham());
            }else {
                respon.setError("Không thành công: Giá không thể là null.");
                return respon;
            }
            if (sanPham.getSanPhamID() != null) {
                sanPham1.setSanPhamID(sanPham.getSanPhamID());
            }
            if (sanPham.getMauSac() != null) {
                sanPham1.setMauSac(sanPham.getMauSac());
            }else {
                respon.setError("Không thành công: Màu Sắc không thể là null.");
                return respon;
            }
            if (sanPham.getTenSanPham() != null) {
                sanPham1.setTenSanPham(sanPham.getTenSanPham());
            }else {
                respon.setError("Không thành công: Tên không thể là null.");
                return respon;
            }
            if (sanPham.getChatLieu() != null) {
                sanPham1.setChatLieu(sanPham.getChatLieu());
            }else {
                respon.setError("Không thành công: Chất liệu không thể là null.");
                return respon;
            }
            if (sanPham.getSize() != null) {
                sanPham1.setSize(sanPham.getSize());
            }else {
                respon.setError("Không thành công: Size không thể là null.");
                return respon;
            }
            if (sanPham.getMoTa() != null) {
                sanPham1.setMoTa(sanPham.getMoTa());
            }else {
                respon.setError("Không thành công: MoTa không thể là null.");
                return respon;
            }
            if (sanPham.getThuongHieu() != null) {
                sanPham1.setThuongHieu(sanPham.getThuongHieu());
            }else {
                respon.setError("Không thành công: Thương Hiêu không thể là null.");
                return respon;
            }
            if (sanPham.getNgayTao() != null) {
                sanPham1.setNgayTao(sanPham.getNgayTao());
            }else {
                respon.setError("Không thành công: Ngày tạo không thể là null.");
                return respon;
            }
            if (sanPham.getSoLuongTon() != null) {
                if (sanPham.getSoLuongTon() instanceof Integer) {
                    sanPham1.setSoLuongTon((Integer) sanPham.getSoLuongTon());
                } else {
                    respon.setError("Không thành công: soLuongTon phải là một số nguyên.");
                    return respon;
                }
            } else {
                respon.setError("Không thành công: soLuongTon không thể là null.");
                return respon;
            }
            if (sanPham.getHinhAnhURL() != null) {
                sanPham1.setHinhAnhURL(sanPham.getHinhAnhURL());
            }else {
                respon.setError("Không thành công: soLuongTon không thể là null.");
                return respon;
            }
            sanPham1.setTinhTrang(sanPham.getTinhTrang());
                sanPhamRepo.save(sanPham1);
                respon.setStatus("Thành công");
        } else {
            respon.setError("Không thành công");
        }

        return respon;
    }
    private boolean isValidSanPham(SanPham sanPham) {
        // Check if any required field is empty or contains only spaces
        return !sanPham.getTenSanPham().trim().isEmpty() &&
                !sanPham.getMoTa().trim().isEmpty() &&
                !sanPham.getHinhAnhURL().trim().isEmpty();
    }

    private void updateSanPhamFields(SanPham sanPham1, SanPham sanPham) {
        // Update non-null fields
        sanPham1.setGiaSanPham(sanPham.getGiaSanPham());
        sanPham1.setSanPhamID(sanPham.getSanPhamID());
        sanPham1.setMauSac(sanPham.getMauSac());
        sanPham1.setTenSanPham(sanPham.getTenSanPham());
        sanPham1.setChatLieu(sanPham.getChatLieu());
        sanPham1.setSize(sanPham.getSize());
        sanPham1.setMoTa(sanPham.getMoTa());
        sanPham1.setThuongHieu(sanPham.getThuongHieu());
        sanPham1.setNgayTao(sanPham.getNgayTao());
        sanPham1.setSoLuongTon(sanPham.getSoLuongTon());
        sanPham1.setTinhTrang(sanPham.getTinhTrang());
        sanPham1.setHinhAnhURL(sanPham.getHinhAnhURL());
    }

    @Override
    public void delete(UUID sanPhamID) {
        sanPhamRepo.deleteByI(sanPhamID);
        SanPham sanPham = sanPhamRepo.findById(sanPhamID).orElse(null);
        sizeService.capnhat(sanPham.getSize().getSizeID(), -sanPham.getSoLuongTon());
        mauSacService.capnhat(sanPham.getMauSac().getMauSacID(), -sanPham.getSoLuongTon());
    }

    @Override
    public SanPham detail(UUID sanPhamID) {
        return sanPhamRepo.findById(sanPhamID).orElse(null);
    }

    @Override
    public Page<SanPham> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamRepo.findByTinhTrang(0, pageable);
    }

    @Override
    public void capnhat(UUID id, int soluong) {
        SanPham sanPham = sanPhamRepo.findById(id).orElse(null);

        if (sanPham != null) {
            int soluongmoi = sanPham.getSoLuongTon() - soluong;
            if (soluongmoi >= 0) {
                sanPham.setSoLuongTon(soluongmoi);
                sanPhamRepo.save(sanPham);
            } else {
                throw new IllegalArgumentException("Số lượng trong sản phẩm không đủ");
            }
        }
    }

    @Override
    public SanPham size(SanPham sanPham, UUID sanPhamID) {
        SanPham sanPham1 = detail(sanPhamID);
        sanPham1.setSize(sanPham.getSize());
        sanPham1.setMauSac(sanPham.getMauSac());
        return sanPhamRepo.save(sanPham1);
    }

    @Override
    public List<SanPham> findtenSanPham(String ten) {
        return sanPhamRepo.findByTenSanPham1(ten);
    }


    @Override
    public List<SanPham> findByMauSacID(int mauSacID) {
        return sanPhamRepo.findByMauSac_MauSacID(mauSacID);
    }

    @Override
    public List<SanPham> findBySizeID(int sizeID) {
        return sanPhamRepo.findBySize_SizeID(sizeID);
    }

    @Override
    public List<SanPham> findByChatLieuID(int chatLieuID) {
        return sanPhamRepo.findByChatLieu_ChatLieuID(chatLieuID);
    }

    @Override
    public List<SanPham> findByThuongHieuID(int thuongHieuID) {
        return sanPhamRepo.findByThuongHieu_ThuongHieuID(thuongHieuID);
    }

    @Override
    public List<SanPham> getTop4SanPhamByGiaThapNhat() {
        return sanPhamRepo.findTop4ByOrderByGiaSanPhamAsc();
    }

    @Override
    public SanPham tim(String ten, String anh, int size, int mausac) {
        return sanPhamRepo.findByTenSanPhamAndHinhAnhURLAndSanPham_Size_SizeIDAndSanPham_MauSac_MauSacID(ten,anh,size,mausac);
    }

    @Override
    public List<Object[]> danhSachHangSapHet(Integer soLuongTon) {
        return sanPhamRepo.danhSachHangSapHet(soLuongTon);
    }

    @Override
    public SanPham saveExcel(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }
}
