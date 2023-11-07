package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="NhaCungCap")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NhaCungCapID")
    private Integer nhaCungCapID;
    @Column(name="TenNhaCungCap")
    private String tenNhaCungCap;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="SoDienThoai")
    private int sdt;
    @Column(name="Email")
    private String email;
}
