package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NhanVien")

public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhanVienID")
    private Integer nhanVienID;

    @NotNull(message = "không được để trống")
    @Column(name = "TenDangNhap")
    private String tenDangNhap;

    @NotNull(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Column(name = "Email")
    private String email;

    @NotNull(message = "không được để trống")
    @Column(name = "MatKhau")
    private String matKhau;

    @NotNull(message = "không được để trống")
    @Column(name = "HoTen")
    private String hoTen;

    @NotNull(message = "không được để trống")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotNull(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\b\\d{10}\\b", message = "Số điện thoại phải có 10 chữ số")
    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "ChucVu")
    private String chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;
}


