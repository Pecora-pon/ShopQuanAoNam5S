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

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "DonHang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DonHangID")
    private UUID donHangID;

    @ManyToOne
    @JoinColumn(name = "KhachHangID")
    private KhachHang khachHang;

    @Column(name = "TenKhach")
    private String tenKhach;

    @Column(name = "SoDienThoai")
    private Integer soDienThoai;

    @ManyToOne
    @JoinColumn(name = "ThongTinVanChuyenID")
    private ThongTinVanChuyen thongTinVanChuyen;

    @ManyToOne
    @JoinColumn(name = "GiamGiaID")
    private GiamGia giamGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "HinhThucThanhToan")
    private String hinhThucThanhToan;

    @Column(name = "NgayDatHang")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDatHang;

    @Column(name = "Note", length = 255)
    private String note;

    @Column(name = "TongTien")
    private Float tongTien;



}

