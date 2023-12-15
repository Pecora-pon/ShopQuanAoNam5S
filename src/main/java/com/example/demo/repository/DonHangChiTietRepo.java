package com.example.demo.repository;

import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface DonHangChiTietRepo extends JpaRepository<DonHangChiTiet, Integer> {
    Page<DonHangChiTiet> findByTrangThai(Integer tinhTrang, Pageable pageable);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =0 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =1 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username1(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =2 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username2(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =3 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username3(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =4 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username4(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =5 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username5(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =6 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username6(String username);
    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1%")
    List<DonHangChiTiet> findByDonHang_NgayDatHang(@Param("ngayDatHang") LocalDate ngaydathang);
    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1%")
    List<DonHangChiTiet> findBySanPham_TenSanPham(@Param("tenSanPham") String tenSanPham);
    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1%")
    List<DonHangChiTiet> findByTongTien(@Param("tongTien") Float tongTien);
    List<DonHangChiTiet> findByDonHang_DonHangID(UUID id);


    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 6 where donHangID =:donHangID",nativeQuery = true)
    void chuyenTrangThaiChoHuy(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =6 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAlllll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 0 where donHangID =:donHangID",nativeQuery = true)
    void chuyenTrangThaiCho(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =5 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAllll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 1 where donHangID =:donHangID",nativeQuery = true)
    void chuyenTrangThai(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =0 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAlll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 2 where donHangID =:donHangID",nativeQuery = true)
    void chuyensangxn(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =1 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 3 where donHangID =:donHangID",nativeQuery = true)
    void chuyensangtc(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =2 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getA();
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =3 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getHuy();
    @Query(value = "SELECT * FROM DonHangChiTiet d WHERE d.donHangID = :donHangID",nativeQuery = true)
    List<DonHangChiTiet> findById(@Param("donHangID") UUID donHangChiTietID);
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 4 where donHangID =:donHangID",nativeQuery = true)
    void chuyensanghuy(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =4 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getHuyy();
    @Query("SELECT MONTH(dhc.ngayNhan) AS month, SUM(dhc.soLuong) AS totalQuantity FROM DonHangChiTiet dhc WHERE YEAR(dhc.ngayNhan) = 2023 and dhc.trangThai=3 GROUP BY MONTH(dhc.ngayNhan)")
    List<Object[]> getTotalQuantityByMonthInYear2023();
    @Query("SELECT MONTH(dhc.ngayNhan) AS month, SUM(dhc.tongTien) AS totalRevenue FROM DonHangChiTiet dhc WHERE YEAR(dhc.ngayNhan) = 2023 and dhc.trangThai=3 GROUP BY MONTH(dhc.ngayNhan)")
    List<Object[]> getTotalRevenueByMonthInYear2023();

    @Query("SELECT dhc.trangThai, COUNT(dhc) FROM DonHangChiTiet dhc GROUP BY dhc.trangThai")
    List<Object[]> countOrdersByStatus();

    List<DonHangChiTiet> findByTrangThai(int trangThai);
}
