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


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GioHangID")
    private Integer gioHangID;
    @Column(name = "SoLuongDat")
    private Integer soLuongDat;
    @ManyToOne
    @JoinColumn(name = "SanPhamID")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "KhachHangID")
    private KhachHang khachHang;
    @Column(name = "TongTien")
    private Float tongTien;
    @Column(name="trangThai")
    private int trangThai;
}
