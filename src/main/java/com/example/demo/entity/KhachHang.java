package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KhachHangID")
    private Integer khachHangId;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "TenDangNhap")
    private String username;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "MatKhau")
    private String password;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "khong duoc de trong")
    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "ChucVu")
    private String chucVu;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

}

