package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import java.time.LocalDate;
@Entity
@Table(name = "NhapKho")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhapKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhapKhoID")
    private Integer nhapKhoID;
    @ManyToOne
    @JoinColumn(name = "MauSacID")
    private MauSac MauSac;
    @ManyToOne
    @JoinColumn(name = "SizeID")
    private Size Size;
    @ManyToOne
    @JoinColumn(name = "ChatLieuID")
    private ChatLieu ChatLieu;
    @Column(name="SoLuongNhap")
    private int soLuongNhap;
    @Column(name="NgayNhap")
    private LocalDate ngayNhap;
    @ManyToOne
    @JoinColumn(name="NhaCungCapID")
    private NhaCungCap NhaCungCap;
    @ManyToOne
    @JoinColumn(name="SanPhamID")
    private SanPham SanPham;
    @Column(name="trangThai")
    private int trangThai;
}
