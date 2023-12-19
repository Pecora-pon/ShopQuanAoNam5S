package com.example.demo.config;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.NhanVien;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class DonHangPDF {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private DonHangChiTiet donHangChiTiet;

    public DonHangPDF() {

        workbook= new XSSFWorkbook();
    }

    public byte[] exportpdf(DonHangChiTiet donHangChiTiet) throws IOException, DocumentException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);

            document.open();

            // Điền dữ liệu

                document.add(new Paragraph("Id: " + donHangChiTiet.getDonHangChiTietID()));
                document.add(new Paragraph("Id: " + donHangChiTiet.getDonHang().getKhachHang().getHoTen()));
                document.add(new Paragraph("Ngày đặt hàng: " + donHangChiTiet.getDonHang().getNgayDatHang().toString()));
                document.add(new Paragraph("So dien thoai: " + donHangChiTiet.getDonHang().getKhachHang().getSoDienThoai()));
                document.add(new Paragraph("Dia chi: " + donHangChiTiet.getDonHang().getKhachHang().getDiaChi()));
                document.add(new Paragraph("Ten san pham : " + donHangChiTiet.getSanPham().getTenSanPham()));
            document.add(new Paragraph("Ten san pham : " + donHangChiTiet.getSanPham().getTenSanPham()));
            document.add(new Paragraph("Ten san pham : " + donHangChiTiet.getSanPham().getTenSanPham()));
                document.add(new Paragraph(""));


            document.close();

            return outputStream.toByteArray();
        }
    }
}
