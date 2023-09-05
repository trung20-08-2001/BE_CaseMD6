package com.be.controller.send_email;

import com.be.model.email.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmailController {
    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("mainzoe9x@gmai.com");
            message.setTo(emailRequest.getTo());
            message.setSubject("Thông báo về kết quả đăng kí làm chủ nhà");
            message.setText("Thông tin của bạn không đủ điều kiện để trở thành người cho thuê nhà. Hãy liên hệ tới admin để biết thêm chi tiết");
            emailSender.send(message);
            return "Email sent successfully!";
        } catch (MailException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
