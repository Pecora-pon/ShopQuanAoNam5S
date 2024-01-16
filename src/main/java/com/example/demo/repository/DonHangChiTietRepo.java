package com.example.demo.repository;

import com.example.demo.entity.DonHang;
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
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DonHangChiTietRepo extends JpaRepository<DonHangChiTiet, Integer> {
    Page<DonHangChiTiet> findByTrangThai(Integer tinhTrang, Pageable pageable);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =0 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =1 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username1(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =2 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username2(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =3 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username3(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =4 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username4(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =5 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username5(String username);

    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =6 order by p.donHangChiTietID desc")
    List<DonHangChiTiet> findByDonHang_KhachHang_Username6(String username);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=0")
    List<DonHangChiTiet> findByDonHang_NgayDatHang(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=1")
    List<DonHangChiTiet> findByDonHang_NgayDatHang1(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=2")
    List<DonHangChiTiet> findByDonHang_NgayDatHang2(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=3")
    List<DonHangChiTiet> findByDonHang_NgayDatHang3(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=4")
    List<DonHangChiTiet> findByDonHang_NgayDatHang4(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=5")
    List<DonHangChiTiet> findByDonHang_NgayDatHang5(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("select p from DonHangChiTiet  p where p.donHang.ngayDatHang LIKE %?1% and p.trangThai=6")
    List<DonHangChiTiet> findByDonHang_NgayDatHang6(@Param("ngayDatHang") LocalDate ngaydathang, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=0")
    List<DonHangChiTiet> findBySanPham_TenSanPham(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=1")
    List<DonHangChiTiet> findBySanPham_TenSanPham1(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=2")
    List<DonHangChiTiet> findBySanPham_TenSanPham2(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=3")
    List<DonHangChiTiet> findBySanPham_TenSanPham3(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=4")
    List<DonHangChiTiet> findBySanPham_TenSanPham4(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=5")
    List<DonHangChiTiet> findBySanPham_TenSanPham5(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("Select p from DonHangChiTiet p where p.sanPham.tenSanPham LIKE %?1% and p.trangThai=6")
    List<DonHangChiTiet> findBySanPham_TenSanPham6(@Param("tenSanPham") String tenSanPham, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=0")
    List<DonHangChiTiet> findByTongTien(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=1")
    List<DonHangChiTiet> findByTongTien1(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=2")
    List<DonHangChiTiet> findByTongTien2(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=3")
    List<DonHangChiTiet> findByTongTien3(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=4")
    List<DonHangChiTiet> findByTongTien4(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=5")
    List<DonHangChiTiet> findByTongTien5(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.tongTien LIKE %?1% and p.trangThai=6")
    List<DonHangChiTiet> findByTongTien6(@Param("tongTien") Float tongTien, int trang);

    @Query("select p from DonHangChiTiet p where p.sanPham.sanPhamID =:sanPhamID")
    DonHangChiTiet findbySanPham(@Param("sanPhamID")UUID id);

    @Query("select p from DonHangChiTiet p where p.donHang.donHangID =:id")
    DonHangChiTiet donHangChiTiet(@Param("id") UUID id);

    @Query("select p from DonHangChiTiet p where p.donHang.donHangID in :id")
    List<DonHangChiTiet> donHangChiTiet1(@Param("id") List<UUID> id);

    List<DonHangChiTiet> findByDonHang_DonHangID(UUID id);

    List<DonHangChiTiet> findByDonHangChiTietID(int id);

    @Query("select p from DonHangChiTiet p where p.donHang.donHangID =:donHangID and p.trangThai =8")
    List<DonHangChiTiet> banHang(@Param("donHangID")UUID id);

    DonHangChiTiet findBySanPhamAndDonHang(SanPham sanPham, DonHang donHang);

    @Query("select p from DonHangChiTiet p where p.donHang.khachHang.username =:username and p.trangThai =3 or p.trangThai =4 order by p.donHangChiTietID desc ")
    List<DonHangChiTiet> vi(String username);

    List<DonHangChiTiet>findAllByDonHangChiTietIDInAndTrangThai(List<Integer> donhang,int page);

    @Modifying
    @Transactional
    @Query("DELETE FROM DonHangChiTiet d WHERE d.donHang.donHangID = :donHangID")
    void deleteByDonHangID(UUID donHangID);

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 6 where donHangID =:donHangID", nativeQuery = true)
    void chuyenTrangThaiChoHuy(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =6 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getAlllll();

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 0 where donHangID =:donHangID", nativeQuery = true)
    void chuyenTrangThaiCho(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =5 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getAllll();

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 1 where donHangID =:donHangID", nativeQuery = true)
    void chuyenTrangThai(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =0 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getAlll();

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 2 where donHangID =:donHangID", nativeQuery = true)
    void chuyensangxn(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =1 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getAll();

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 3 where donHangID =:donHangID", nativeQuery = true)
    void chuyensangtc(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =2 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getA();

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =3 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getHuy();

    @Query(value = "SELECT * FROM DonHangChiTiet d WHERE d.donHangID = :donHangID", nativeQuery = true)
    List<DonHangChiTiet> findById(@Param("donHangID") UUID donHangChiTietID);

    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 4 where donHangID =:donHangID", nativeQuery = true)
    void chuyensanghuy(@Param("donHangID") UUID donHangChiTietID);

    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =4 order by p.donHangChiTietID desc", nativeQuery = true)
    List<DonHangChiTiet> getHuyy();

 @Query("SELECT dhc.ngayNhan,SUM(dhc.soLuong) AS totalQuantity " +
            "FROM DonHangChiTiet dhc " +
            "WHERE dhc.trangThai = 3 AND dhc.ngayNhan = :selectedDate " +
            "GROUP BY dhc.ngayNhan")
    List<Object[]> getTotalQuantityByMonthInYear2023(@Param("selectedDate")LocalDate selectedDate );
    @Query("SELECT SUM(dhc.soLuong) AS totalQuantity " +
            "FROM DonHangChiTiet dhc " +
            "WHERE dhc.trangThai = 3")
    Long getTotalObject();

    @Query("SELECT dhc.ngayNhan AS date, SUM(dhc.tongTien) AS totalRevenue FROM DonHangChiTiet dhc WHERE dhc.trangThai = 3 GROUP BY date,(dhc.ngayNhan)")
    List<Object[]> getTotalRevenueByMonthInYear2023();
    @Query("SELECT MONTH(dhc.ngayNhan) AS month, SUM(dhc.tongTien) AS totalRevenue " +
            "FROM DonHangChiTiet dhc " +
            "WHERE dhc.trangThai = 3 AND MONTH(dhc.ngayNhan) = MONTH(CURRENT_DATE()) " +
            "GROUP BY month(dhc.ngayNhan)")
    List<Object[]> getTotalRevenueForCurrentMonth();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 0")
    long countDistinctDonHangByTrangThai0();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 1")
    long countDistinctDonHangByTrangThai1();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 2")
    long countDistinctDonHangByTrangThai2();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 3")
    long countDistinctDonHangByTrangThai3();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 4")
    long countDistinctDonHangByTrangThai4();

    @Query("SELECT COUNT(DISTINCT dhc.donHang) FROM DonHangChiTiet dhc WHERE dhc.trangThai = 5")
    long countDistinctDonHangByTrangThai5();

    List<DonHangChiTiet> findByTrangThai(int trangThai);


}
