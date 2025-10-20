package zw.co.Afrosoft.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import zw.co.Afrosoft.NotificationRequest;
import zw.co.Afrosoft.Notification;
import zw.co.Afrosoft.NotificationsRepository;
import zw.co.Afrosoft.Response;

import java.util.Date;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
    private final EmailService emailService;
    private final NotificationsRepository notificationRepository;

    @Autowired
    public EmailController(EmailService emailService, NotificationsRepository notificationRepository) {
        this.emailService = emailService;
        this.notificationRepository = notificationRepository;
    }
    @PostMapping("/send")
    public ResponseEntity<Response> sendEmail(@RequestBody NotificationRequest emailRequest) throws RuntimeException {
//        if (emailRequest.isEmail()) {
            Notification notification = new Notification();
            notification.setContent(emailRequest.getContent());
            notification.setSubject(emailRequest.getSubject());
            notification.setRecipient(emailRequest.getRecipient());
            emailService.sendEmail(notification);
//        Notification notification = createNotification(emailRequest);
//        notificationRepository.save(notification);
        return ResponseEntity.ok(new Response("Success", "Email delivered"));
        //        }
    }

    private Notification createNotification(NotificationRequest notificationRequest) {
        Notification notification = new Notification();
        notification.setContent(notificationRequest.getContent());
        notification.setSubject(notificationRequest.getSubject());
        notification.setDateCreated(new Date());
        notification.setRecipient(notificationRequest.getRecipient());
        notification.setEmail(notificationRequest.isEmail());
        notification.setSMS(notificationRequest.isSMS());
        notification.setPush(notificationRequest.isPush());
        notification.setStatus("Sent"); // You can update the status as needed
        return notification;
    }
}

