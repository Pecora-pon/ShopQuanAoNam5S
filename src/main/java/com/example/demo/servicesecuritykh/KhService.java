package com.example.demo.servicesecuritykh;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.RanDom;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.KhachHangRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class KhService {
    private final KhachHangRepo khachHangRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;
    public Respon<KhachHang> addKH(KhachHang khachHang, HttpServletRequest request)throws MessagingException {
        khachHang.setChucVu("ROLE_USER");

        Respon<KhachHang> respon=new Respon<>();
        if(!khachHang.getUsername().isEmpty() || !khachHang.getEmail().isEmpty()||!khachHang.getPassword().isEmpty()||!khachHang.getHoTen().isEmpty()||!khachHang.getSoDienThoai().isEmpty()){
            if(isvalidate(request.getParameter("password"))){
              if(isvalidSDT(request.getParameter("soDienThoai"))){
                  if(isValidEmail(khachHang.getEmail())){
                      if(!khachHangRepo.findBySoDienThoai(khachHang.getSoDienThoai()).isPresent()){
                          if(!khachHangRepo.findByusername(khachHang.getUsername()).isPresent()){
                              if(!khachHangRepo.findByEmail(khachHang.getEmail()).isPresent()){
                                  khachHang.setPassword(passwordEncoder.encode(khachHang.getPassword()));
                                  MimeMessage message = mailSender.createMimeMessage();
                                  MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");

                                  helper.setTo(khachHang.getEmail());
                                  String subject = "Đây là mail xác nhận đăng ký tài khoản của bạn đã thành công";

                                  String content = "<p>Chào bạn " +khachHang.getHoTen()+", </p>"+ "<p>Bạn đã đăng ký thành công tài khoản của mình.</p>"
                                          + "<p>Cảm ơn bạn đã tin tưởng 5sOnline, "
                                          + "hãy đăng nhập và đặt mua chiếc áo mà bạn thích ngay nào!!!</p>"
                                          +"<p>Đây là thông tin đăng nhập của bạn</p>"
                                          +"<p>Tài khoản: "+khachHang.getUsername()+"</p>"
                                          +"<p>Mật khẩu: "+request.getParameter("password")+"</p>";
                                  helper.setSubject(subject);
                                  helper.setText(content,true);
                                  mailSender.send(message);
                                  khachHang.setTrangThai(3);
                                  khachHangRepo.save(khachHang);
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

    public Respon<KhachHang> ForgotPasswordKH(KhachHang khachHang)throws MessagingException{
        Respon<KhachHang> respon=new Respon<>();
        String token = RanDom.generateRandomString(30);
        String email = khachHang.getEmail();
        String resetPasswordLink = "http://localhost:8080/reset_password/"+token;
        if(!khachHang.getEmail().isEmpty() ){
            if(isValidEmail(khachHang.getEmail())){
                if(khachHangRepo.findByEmail(khachHang.getEmail()).isPresent()){
                    MimeMessage message = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
                    helper.setTo(khachHang.getEmail());
                    String subject = "Đây là liên kết để đặt lại mật khẩu của bạn";

                    String content = "<p>Xin chào!,</p>" + "<p>Bạn đã yêu cầu đặt lại mật khẩu của mình.</p>"
                            + "<p>Nhấp vào liên kết bên dưới để thay đổi mật khẩu của bạn:</p>" + "<p><a href=\"" + resetPasswordLink
                            + "\">Thay đổi mật khẩu của bạn</a></p>" + "<br>"
                            + "<p>Hãy bỏ qua email này nếu bạn nhớ mật khẩu của mình, "
                            + "hoặc nếu bạn đã không thực hiện yêu cầu này.</p>";
                    helper.setSubject(subject);
                    helper.setText(content,true);
                    mailSender.send(message);
                    updateResetPasswordToken(token,email);
                    respon.setStatus("Vui lòng check email để đặt lại mật khẩu");
                }else {
                    respon.setError("Email chưa được đăng kí");
                }
            }else {
                respon.setError("Vui lòng nhập email đúng định dạng");
            }
        }else{
            respon.setError("Vui lòng nhập email");
        }
        return  respon;
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

    public void updateResetPasswordToken(String token, String email)  {
        KhachHang khachHang = khachHangRepo.findByemail(email);
            khachHang.setResetPasswordToken(token);
            khachHangRepo.save(khachHang);
    }
    public KhachHang getByResetPasswordToken(String token) {
        return khachHangRepo.findByResetPasswordToken(token);
    }


    public Respon<KhachHang> updatePassword(KhachHang khachHang, String newPassword,String token) {
        Respon<KhachHang> respon = new Respon<>();
        String encodedPassword = passwordEncoder.encode(newPassword);
        khachHang.setPassword(encodedPassword);
        khachHang.setResetPasswordToken(null);
        khachHangRepo.save(khachHang);
        respon.setStatus("Đặt lại mật khẩu thành công");
        return respon;
    }
    public boolean isResetPasswordTokenUsed(String token) {
        KhachHang khachHang = khachHangRepo.findByResetPasswordToken(token);
        return khachHang == null || khachHang.isResetPasswordTokenUsed();
    }

    // Đánh dấu token đã được sử dụng
    public void markResetPasswordTokenAsUsed(String token) {
        KhachHang khachHang = khachHangRepo.findByResetPasswordToken(token);
        if (khachHang != null) {
            khachHang.setResetPasswordTokenUsed(true);
            khachHangRepo.save(khachHang);
        }
    }


}
