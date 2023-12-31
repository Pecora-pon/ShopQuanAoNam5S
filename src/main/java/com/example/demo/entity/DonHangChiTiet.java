package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DonHangChiTiet")
public class DonHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonHangChiTietID")
    private Integer donHangChiTietID;

    @ManyToOne
    @JoinColumn(name = "DonHangID")
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "SanPhamID")
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "LyDoHuy")
    private String lyDoHuy;

    @Column(name = "TongTien")
    private Float tongTien;

    @Column(name= "NgayNhan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayNhan;
}

