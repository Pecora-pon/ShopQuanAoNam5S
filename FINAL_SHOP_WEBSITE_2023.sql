CREATE DATABASE FINAL_SHOP_WEBSITE_2023
USE	FINAL_SHOP_WEBSITE_2023
DROP DATABASE FINAL_SHOP_WEBSITE_2023
--các bảng chính
GO
CREATE TABLE ChucVu(
	ChucVuID INT IDENTITY(1,1) PRIMARY KEY,
	TenChucVu NVARCHAR(50),

)
INSERT INTO ChucVu(TenChucVu) VALUES (N'Quản lý')
INSERT INTO ChucVu(TenChucVu) VALUES (N'Khách hàng')
INSERT INTO ChucVu(TenChucVu) VALUES (N'Nhân viên')
Select * from ChucVu

Go
CREATE TABLE KhachHang(
	KhachHangID INT IDENTITY(1,1)PRIMARY KEY,
	TenDangNhap NVARCHAR(255),
	Email NVARCHAR(255),
	MatKhau NVARCHAR(50),
	HoTen NVARCHAR(255),																			
	DiaChi NVARCHAR(255),
	SoDienThoai NVARCHAR(50),
	--ChucVu NVARCHAR(255),-- Có thể tách ra làm 1 bảng riêng
	ChucVu INT FOREIGN KEY REFERENCES ChucVu(ChucVuID)

)

Go
CREATE TABLE NhanVien(
	NhanVienID INT IDENTITY(1,1)PRIMARY KEY,
	TenDangNhap NVARCHAR(255),
	Email NVARCHAR(255),
	MatKhau NVARCHAR(50),
	HoTen NVARCHAR(255),
	DiaChi NVARCHAR(255),
	SoDienThoai NVARCHAR(50),
	TrangThai BIT,
	--ChucVu NVARCHAR(255),-- Có thể tách ra làm 1 bảng riêng
	ChucVu INT FOREIGN KEY REFERENCES ChucVu(ChucVuID)

)
Go
CREATE TABLE ChatLieu(
	ChatLieuID INT IDENTITY(1,1) PRIMARY KEY,
	TenChatLieu NVARCHAR(255)
)
Go
CREATE TABLE ThuongHieu(
	ThuongHieuID INT IDENTITY(1,1) PRIMARY KEY,
	TenThuongHieu NVARCHAR(255)
)
GO
CREATE TABLE MauSac(
	MauSacID INT IDENTITY(1,1) PRIMARY KEY,
	TenMauSac NVARCHAR(255)
)
GO
CREATE TABLE Size(
	SizeID INT IDENTITY(1,1) PRIMARY KEY,
	TenSize NVARCHAR(255),
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
)
Go
CREATE TABLE HinhAnh(
	HinhAnhID INT IDENTITY(1,1) PRIMARY KEY,
	HinhAnhURL NVARCHAR(MAX),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID)
)
Go
CREATE TABLE GioHang(
	GioHangID INT IDENTITY(1,1) PRIMARY KEY,
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	SoLuongDat INT,
)
GO
CREATE TABLE ThongTinVanChuyen(
	ThongTinVanChuyenID INT IDENTITY(1,1) PRIMARY KEY,
	DiaChi NVARCHAR(MAX), -- Địa chỉ giao hàng,
	PhuongThuc NVARCHAR(255), --Giao Hàng nhanh , giao hàng tiêu chuẩn
	TrangThai INT , --0 là đang giao, 1 là đã giao xong
)
GO
CREATE TABLE GiamGia(
	GiamGiaID INT IDENTITY(1,1) PRIMARY KEY,
	MaGiamGia NVARCHAR(255),
	SoTienGiam MONEY,
	NgayTao DATE,
	NgayHetHan DATE,
)
GO
CREATE TABLE DonHang(
	DonHangID UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	KhachHangID INT FOREIGN KEY REFERENCES KhachHang(KhachHangID) NULL,--Giúp khách hàng không cần đăng nhập vẫn mua được hàng
	TenKhach NVARCHAR(255) NULL, --Null cho những khách hàng có tài khoản user
	SoDienThoai INT Null, --Null cho những khách hàng có tài khoản user
	ThongTinVanChuyenID INT FOREIGN KEY REFERENCES ThongTinVanChuyen(ThongTinVanChuyenID),
	GiamGiaID INT FOREIGN KEY REFERENCES GiamGia(GiamGiaID),--Giảm giá theo từng sản phẩm
	TrangThai INT, -- 0 là đang xử lý /1 là đã giao hàng
	HinhThucThanhToan NVARCHAR(255), -- Thanh toán khi nhận hàng / thanh toán qua thẻ tín dụng/Momo. Có thể tách ra thành 1 table riêng
	NgayDatHang DATE,
	TongTien MONEY,
	Note NVARCHAR(255), -- yêu cầu thêm của khách hàng
)
Go
CREATE TABLE DonHangChiTiet(
	DonHangChiTietID UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
	DonHangID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES DonHang(DonHangID),
	SanPhamID UNIQUEIDENTIFIER FOREIGN KEY REFERENCES SanPham(SanPhamID),
	SoLuong INT,
	TrangThai BIT,
	LyDoHuy NVARCHAR(255),

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
	 BinhLuan NVARCHAR(MAX)
)


