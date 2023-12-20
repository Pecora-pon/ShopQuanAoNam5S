package com.example.demo.servicesecurity;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.NhanVienRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NhanVienRepo nhanVienRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;

    public Respon<NhanVien> addUser(NhanVien nhanVien, HttpServletRequest request) throws MessagingException {
        nhanVien.setChucVu("ROLE_ADMIN");

        Respon<NhanVien> respon=new Respon<>();
        if(!nhanVien.getTenDangNhap().isEmpty() || !nhanVien.getEmail().isEmpty()||!nhanVien.getMatKhau().isEmpty()||!nhanVien.getHoTen().isEmpty()||!nhanVien.getSoDienThoai().isEmpty()||!nhanVien.getDiaChi().isEmpty()){
            if(isvalidate(request.getParameter("matKhau"))){
                if(isvalidSDT(request.getParameter("soDienThoai"))){
                    if(isValidEmail(nhanVien.getEmail())){
                        if(!nhanVienRepo.findBySoDienThoai(nhanVien.getSoDienThoai()).isPresent()){
                            if(!nhanVienRepo.findByTenDangNhap(nhanVien.getTenDangNhap()).isPresent()){
                                if(!nhanVienRepo.findByEmail(nhanVien.getEmail()).isPresent()){
                                    nhanVien.setMatKhau(passwordEncoder.encode(nhanVien.getMatKhau()));
                                    MimeMessage message = mailSender.createMimeMessage();
                                    MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");

                                    helper.setTo(nhanVien.getEmail());
                                    String subject = "Đây là mail xác nhận nhân viên mới";

                                    String content = "<p>Chào bạn " +nhanVien.getHoTen()+", </p>"+ "<p>Bạn là nhân viên mới của 5SOnline</p>"


                                            +"<p>Đây là thông tin đăng nhập của bạn</p>"
                                            +"<p>Tài khoản: "+nhanVien.getTenDangNhap()+"</p>"
                                            +"<p>Mật khẩu: "+request.getParameter("matKhau")+"</p>";
                                    helper.setSubject(subject);
                                    helper.setText(content,true);
                                    mailSender.send(message);
                                    nhanVien.setTrangThai(3);
                                   nhanVienRepo.save(nhanVien);
                                    respon.setStatus("Đăng kí thành công ");
                                }else{
                                    respon.setError("Email đã đăng kí");
                                }
                            }else {
                                respon.setError("Tên đăng nhập đã tồn tại");
                            }
                        }else {
                            respon.setError("Số điện thoại đã đăng kí");
                        }
                    }else{
                        respon.setError("Vui lòng nhập email đúng định dạng");
                    }
                }else {
                    respon.setError("Vui lòng nhập số điện thoại đúng định dạng");
                }
            }else {
                respon.setError("Mật khẩu có ít nhất 8 ký tự, bao gồm ít nhất một chữ cái viết thường, một chữ cái viết hoa, và một số và không để khoảng trắng");
            }
        }else {
            respon.setError("Vui lòng nhập đẩy đủ dữ liệu");
        }
        return respon;


    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    private boolean isvalidate(String matkhau){
        String matkhauregex ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)\\P{Z}{8,}$";
        Pattern pattern = Pattern.compile(matkhauregex);
        Matcher matcher= pattern.matcher(matkhau);
        return matcher.matches();

    }
    private boolean isvalidSDT(String soDienThoai){
        String sdtRegex = "^\\+?[0-9]{1,4}[-.\\s]?[0-9]{1,14}$";
        Pattern pattern = Pattern.compile(sdtRegex);
        Matcher matcher = pattern.matcher(soDienThoai);
        return matcher.matches();

    }
}
