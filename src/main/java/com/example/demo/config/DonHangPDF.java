package com.example.demo.config;

import com.example.demo.entity.DonHang;
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
    private DonHang donHang;

    public DonHangPDF() {

        workbook= new XSSFWorkbook();
    }

    public byte[] exportpdf(DonHang donHang) throws IOException, DocumentException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);

            document.open();

            // Điền dữ liệu

                document.add(new Paragraph("Id: " + donHang.getDonHangID()));
                document.add(new Paragraph("Ten khach hang: " + donHang.getKhachHang().getHoTen()));
                document.add(new Paragraph("So dien thoai: " + donHang.getKhachHang().getSoDienThoai()));
                document.add(new Paragraph("Dia chi: " + donHang.getKhachHang().getDiaChi()));
                document.add(new Paragraph("Hinh thuc thanh toan: " + donHang.getHinhThucThanhToan()));
                document.add(new Paragraph("Ngay thanh toan: " + donHang.getNgayDatHang().toString()));

                document.add(new Paragraph(""));


            document.close();

            return outputStream.toByteArray();
        }
    }
}
