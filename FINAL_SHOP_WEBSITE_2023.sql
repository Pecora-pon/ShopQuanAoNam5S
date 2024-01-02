CREATE DATABASE FINAL_SHOP_WEBSITE_2023
USE	FINAL_SHOP_WEBSITE_2023
DROP DATABASE FINAL_SHOP_WEBSITE_2023
--các bảng chính

GO
--CREATE TABLE ChucVu(
	--ChucVuID INT IDENTITY(1,1) PRIMARY KEY,
	--TenChucVu NVARCHAR(50),

--)
--INSERT INTO ChucVu(TenChucVu) VALUES (N'Quản lý')
--INSERT INTO ChucVu(TenChucVu) VALUES (N'Khách hàng')
--Select * from ChucVu

--Go

CREATE TABLE KhachHang(
	KhachHangID INT IDENTITY(1,1)PRIMARY KEY,
	TenDangNhap NVARCHAR(255),
	Email NVARCHAR(255),
	MatKhau NVARCHAR(MAX),
	HoTen NVARCHAR(255),																			
	DiaChi NVARCHAR(255),
	SoDienThoai NVARCHAR(50),
	ChucVu NVARCHAR(MAX),
	Reset_password_token VARCHAR(30),
	is_reset_password_token_used BIT,
	TrangThai INT
    
)

Go
CREATE TABLE NhanVien(
	NhanVienID INT IDENTITY(1,1)PRIMARY KEY,
	TenDangNhap NVARCHAR(255),
	Email NVARCHAR(255),
	MatKhau NVARCHAR(MAX),
	HoTen NVARCHAR(255),
	DiaChi NVARCHAR(255),
	SoDienThoai NVARCHAR(50),
	TrangThai BIT,
	ChucVu NVARCHAR(MAX),

)
Go
CREATE TABLE ChatLieu(
	ChatLieuID INT IDENTITY(1,1) PRIMARY KEY,
	TenChatLieu NVARCHAR(255),
	trangThai int
)
Go
CREATE TABLE ThuongHieu(
	ThuongHieuID INT IDENTITY(1,1) PRIMARY KEY,
	TenThuongHieu NVARCHAR(255),
	trangThai int
)
GO
CREATE TABLE MauSac(
	MauSacID INT IDENTITY(1,1) PRIMARY KEY,
	TenMauSac NVARCHAR(255),
	trangThai int,
	SoLuong INT
)
GO
CREATE TABLE Size(
	SizeID INT IDENTITY(1,1) PRIMARY KEY,
	TenSize NVARCHAR(255),
	trangThai int,
	SoLuong INT
)
Go
CREATE TABLE SanPham(
	SanPhamID UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	TenSanPham NVARCHAR(255),
	MoTa NVARCHAR(MAX),
	GiaSanPham MONEY,
	NgayTao DATE,
	SoLuongTon INT,
	TinhTrang INT,--0 là còn hàng,1 là tạm hết hàng , 2 là đã bán hết
	MauSacID INT FOREIGN KEY REFERENCES MauSac(MauSacID),
	SizeID INT FOREIGN KEY REFERENCES Size(SizeID),
	ChatLieuID INT FOREIGN KEY REFERENCES ChatLieu(ChatLieuID),
	ThuongHieuID INT FOREIGN KEY REFERENCES ThuongHieu(ThuongHieuID),
	HinhAnhURL NVARCHAR(Max),
)
Go
CREATE TABLE GioHang(
	GioHangID INT IDENTITY(1,1) PRIMARY KEY,
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	SoLuongDat INT,
	TongTien FLOAT,
	trangThai INT
)
GO
CREATE TABLE ThongTinVanChuyen(
	ThongTinVanChuyenID INT IDENTITY(1,1) PRIMARY KEY,
	DiaChi NVARCHAR(MAX), -- Địa chỉ giao hàng,
	PhuongThuc NVARCHAR(255), --Giao Hàng nhanh , giao hàng tiêu chuẩn
	TrangThai INT , --0 là đang giao, 1 là đã giao xong
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID)

)
GO
CREATE TABLE GiamGia(
	GiamGiaID INT IDENTITY(1,1) PRIMARY KEY,
	MaGiamGia NVARCHAR(255),
	TenSuKien NVARCHAR(255),
	NhanVienID INT FOREIGN KEY REFERENCES NhanVien(NhanVienID),
	NgayTao DATE,
	NgayHetHan DATE,
	SoTienGiam float
)
Go

GO
CREATE TABLE DonHang(
	DonHangID UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID) NULL,--Giúp khách hàng không cần đăng nhập vẫn mua được hàng
	TenKhach NVARCHAR(255) NULL, --Null cho những khách hàng có tài khoản user
	SoDienThoai INT Null, --Null cho những khách hàng có tài khoản user
	ThongTinVanChuyenID INT FOREIGN KEY REFERENCES ThongTinVanChuyen(ThongTinVanChuyenID),
	TrangThai INT, -- 0 là đang xử lý /1 là đã giao hàng
	HinhThucThanhToan NVARCHAR(255), -- Thanh toán khi nhận hàng / thanh toán qua thẻ tín dụng/Momo. Có thể tách ra thành 1 table riêng
	NgayDatHang DATE,
	Note NVARCHAR(255), -- yêu cầu thêm của khách hàng
	GiamGiaID INT FOREIGN KEY REFERENCES GiamGia(GiamGiaID),--Giảm giá theo từng sản phẩm
)
Go
CREATE TABLE DonHangChiTiet(
	DonHangChiTietID INT IDENTITY(1,1) PRIMARY KEY,
	DonHangID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES DonHang(DonHangID),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	SoLuong INT,
	TrangThai int,
	LyDoHuy NVARCHAR(255),
	TongTien MONEY,
	NgayNhan DATE

)
GO
CREATE TABLE KhoHang(
	KhoHangID INT IDENTITY(1,1) PRIMARY KEY,
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	MauSacID INT FOREIGN KEY REFERENCES MauSac(MauSacID),
	SizeID INT FOREIGN KEY REFERENCES Size(SizeID),
	ChatLieuID INT FOREIGN KEY REFERENCES ChatLieu(ChatLieuID),
	SoLuongTon INT,
	NgayCapNhat DATE,
)
GO
CREATE TABLE NhaCungCap(
	NhaCungCapID INT IDENTITY (1,1) PRIMARY KEY,
	TenNhaCungCap NVARCHAR(255),
	DiaChi NVARCHAR(MAX),
	SoDienThoai INT,
	Email NVARCHAR(255),
	trangThai int,
)
Go
CREATE TABLE NhapKho(
	NhapKhoID INT IDENTITY(1,1) PRIMARY KEY,
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	MauSacID INT FOREIGN KEY REFERENCES MauSac(MauSacID),
	SizeID INT FOREIGN KEY REFERENCES Size(SizeID),
	ChatLieuID INT FOREIGN KEY REFERENCES ChatLieu(ChatLieuID),
	SoLuongNhap INT,
	NgayNhap DATE,
	NhaCungCapID INT FOREIGN KEY REFERENCES NhaCungCap(NhaCungCapID),
	trangThai int,
)
GO
CREATE TABLE XuatKho(
	XuatKhoID INT IDENTITY(1,1) PRIMARY KEY,
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	MauSacID INT FOREIGN KEY REFERENCES MauSac(MauSacID),
	SizeID INT FOREIGN KEY REFERENCES Size(SizeID),
	ChatLieuID INT FOREIGN KEY REFERENCES ChatLieu(ChatLieuID),
	SoLuongXuat INT,
	NgayXuat DATE,
	NhaCungCapID INT FOREIGN KEY REFERENCES NhaCungCap(NhaCungCapID),
	trangThai int,

)

--Các bảng khác
GO
CREATE TABLE DanhSachYeuThich(
	DanhSachYeuThichID INT IDENTITY(1,1) PRIMARY KEY,
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID),
)
Go
CREATE TABLE DanhSachSanPhamYeuThich(
	DanhSachSanPhamYeuThich	INT IDENTITY(1,1) PRIMARY KEY,
	DanhSachYeuThichID INT FOREIGN KEY REFERENCES DanhSachYeuThich(DanhSachYeuThichID),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
)
Go
CREATE TABLE ReviewNguoiDung(
	 ReviewID INT IDENTITY(1,1) PRIMARY KEY,
	 SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	 KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID),
	 BinhLuan NVARCHAR(MAX),
	 HinhAnhURL NVARCHAR(Max),
)


