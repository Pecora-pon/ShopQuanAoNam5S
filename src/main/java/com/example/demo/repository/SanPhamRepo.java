package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
    boolean existsByTenSanPham(String tenSanPham);

    Page<SanPham> findByTinhTrang(Integer tinhTrang, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 AND sp.size LIKE %?1% AND sp.thuongHieu LIKE %?2% AND" +
            " sp.tenSanPham LIKE %?3%")
    Page<SanPham> getPages(String sizeID,
                           String thuonghieuID,
                           String tenSanPham,
                           Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang =0 and sp.thuongHieu LIKE %?1%")
    List<SanPham> findByThuongHieuID(String thuongHieuID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 and sp.mauSac LIKE %?1%")
    Page<SanPham> findByMauSacID(String mauSacID, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 and sp.chatLieu LIKE %?1%")
    Page<SanPham> findByChatLieuID(String chatLieuID, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 and sp.size LIKE %?1%")
    Page<SanPham> findBySizeID(String sizeID, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 and sp.tenSanPham LIKE %?1%")
    Page<SanPham> findByTenSanPham(String tenSanPham, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.hinhAnhURL LIKE %?1%")
    List<SanPham> findByHinhAnhURL(String hinhAnhURL);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tinhTrang = 0 and    sp.giaSanPham BETWEEN ?1 AND ?2")
    Page<SanPham> findProductsInPriceRange(Double minPrice, Double maxPrice, Pageable pageable);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham =:tenSanPham")
    SanPham findByTen(@Param("tenSanPham") String tenSanPham);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham =:tenSanPham")
    List<SanPham> findByTenSanPham1(@Param("tenSanPham") String tenSanPham);

    @Query("SELECT sp from SanPham  sp where sp.tenSanPham LIKE :ten or sp.size.tenSize like :ten or sp.mauSac.tenMauSac like :ten")
    List<SanPham> findByTenSanPhamOrSize_TenSizeOrMauSac_TenMauSac(@Param("ten") String ten);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham = :tenSanPham AND sp.hinhAnhURL = :hinhAnhURL AND sp.size.sizeID = :sizeID AND sp.mauSac.mauSacID = :mauSacID")
    SanPham findByTenSanPhamAndHinhAnhURLAndSanPham_Size_SizeIDAndSanPham_MauSac_MauSacID(
            @Param("tenSanPham") String tenSanPham,
            @Param("hinhAnhURL") String hinhAnhURL,
            @Param("sizeID") int sizeID,
            @Param("mauSacID") int mauSacID
    );
    @Query("SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham " +
            "AND s.mauSac.mauSacID = :tenMauSac " +
            "AND s.size.sizeID = :tenSize " +
            "AND s.chatLieu.chatLieuID = :tenChatLieu " +
            "AND s.thuongHieu.thuongHieuID = :tenThuongHieu")
    SanPham findByTenAndAttributes(
            @Param("tenSanPham") String tenSanPham,
            @Param("tenMauSac") int tenMauSac,
            @Param("tenSize") int tenSize,
            @Param("tenChatLieu") int tenChatLieu,
            @Param("tenThuongHieu") int tenThuongHieu
    );

    @Query("SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham " +
            "AND s.mauSac.tenMauSac = :tenMauSac " +
            "AND s.size.tenSize = :tenSize " +
            "AND s.chatLieu.tenChatLieu = :tenChatLieu " +
            "AND s.thuongHieu.tenThuongHieu = :tenThuongHieu")
    SanPham findByTenAndAttributes1(
            @Param("tenSanPham") String tenSanPham,
            @Param("tenMauSac") String tenMauSac,
            @Param("tenSize") String tenSize,
            @Param("tenChatLieu") String tenChatLieu,
            @Param("tenThuongHieu") String tenThuongHieu
    );

    Optional<SanPham> findById(UUID sanPhamID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.mauSac.mauSacID =:mauSacID")
    List<SanPham> findByMauSac_MauSacID(@Param("mauSacID") int tenMauSac);

    @Query("SELECT sp FROM SanPham sp WHERE sp.size.sizeID =:sizeID")
    List<SanPham> findBySize_SizeID(@Param("sizeID") int tenSize);

    @Query("SELECT sp FROM SanPham sp WHERE sp.chatLieu.chatLieuID =:chatLieuID")
    List<SanPham> findByChatLieu_ChatLieuID(@Param("chatLieuID") int tenChatLieu);

    @Query("SELECT sp FROM SanPham sp WHERE sp.thuongHieu.thuongHieuID =:thuongHieuID")
    List<SanPham> findByThuongHieu_ThuongHieuID(@Param("thuongHieuID") int tenthuongHieu);

    @Query("select sp from SanPham sp order by sp.ngayTao desc ")
    List<SanPham> sapxep();

    List<SanPham> findBySanPhamID(UUID sanPhamID);

    @Transactional
    @Modifying
    @Query(value = "Update SanPham set tinhTrang = 1 where sanPhamID =:sanPhamID", nativeQuery = true)
    void deleteByI(@Param("sanPhamID") UUID sanPhamID);

    @Query(value = "select * from SanPham p WHERE  p.tinhTrang=0 order by p.ngayTao desc", nativeQuery = true)
    List<SanPham> getAll();

    @Query(value = "select * from SanPham p WHERE  p.tinhTrang=0 order by p.ngayTao desc", nativeQuery = true)
    List<SanPham> getAlll();

    @Query(value = "SELECT TOP 4 * FROM SanPham ORDER BY GiaSanPham ASC", nativeQuery = true)
    List<SanPham> findTop4ByOrderByGiaSanPhamAsc();

    @Query(value = "SELECT TOP 5 p.tenSanPham, SUM(dhct.SoLuong) AS tongSoLuong "
            + "FROM DonHangChiTiet dhct "
            + "JOIN SanPham p ON dhct.SanPhamID = p.SanPhamID "
            + "WHERE dhct.TrangThai = 3 "
            + "GROUP BY p.tenSanPham "
            + "ORDER BY tongSoLuong DESC", nativeQuery = true)
    List<Object[]> findTopProducts();

    //Thoogns ke
    @Query("select sp.tenSanPham, sp.size.tenSize, \n" +
            "sp.mauSac.tenMauSac, sp.chatLieu.tenChatLieu,sp.thuongHieu.tenThuongHieu , sp.soLuongTon\n" +
            "from SanPham sp\n" +
            "where sp.soLuongTon <= :soLuongTon and sp.tinhTrang = 0")
    List<Object[]> danhSachHangSapHet(@Param("soLuongTon") Integer soLuongTon);
}
