//package zw.co.Afrosoft.Email;
//import jakarta.annotation.Resource;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import zw.co.Afrosoft.Exceptions.EmailException ;
//import zw.co.Afrosoft.Notification;
//import zw.co.Afrosoft.NotificationsRepository;
//
//@Service
//@Resource
//@RequiredArgsConstructor
//public class EmailService {
//    private final JavaMailSender mailSender;
//
//@Async
//    public void sendEmail(Notification notification) {
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("noreply@afrosoft.co.zw");
//            message.setTo(notification.getRecipient().getEmail());
//            message.setSubject(notification.getSubject());
//            message.setText(notification.getContent());
//            mailSender.send(message);
//        } catch (MailException e) {
//            throw new EmailException("Failed to send email.", e);
//        }
//    }
//}
