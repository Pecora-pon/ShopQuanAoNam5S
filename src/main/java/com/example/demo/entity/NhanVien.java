<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
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
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhanVienID")
<<<<<<< HEAD
=======
    private Integer NhanVienId;

    @Column(name = "TenDangNhap")
    private String tenDangNhap;

    @Column(name = "Email")
    private String email;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

//    @ManyToOne
//    @JoinColumn(name = "ChucVuID")
//    private ChucVu chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;



}


=======
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
import org.springframework.security.core.userdetails.User;


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
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
    private Integer nhanVienID;

    @Column(name = "TenDangNhap")
    private String tenDangNhap;

    @Column(name = "Email")
    private String email;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "ChucVu")
    private Integer chucVu;

    @Column(name = "TrangThai")
    private Integer trangThai;



}


<<<<<<< HEAD
=======
>>>>>>> 2e4f6e7d57debb762378d8ed3b259c94427d5a8a
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
