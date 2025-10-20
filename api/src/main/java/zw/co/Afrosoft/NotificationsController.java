//package zw.co.Afrosoft;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//import zw.co.Afrosoft.Email.EmailService;
//import zw.co.Afrosoft.Firebase.FirebaseService;
//import zw.co.Afrosoft.sms.SmsService;
//
//@RestController
//@RequestMapping("/notifications")
//@RequiredArgsConstructor
//public class NotificationsController {
//    private final EmailService emailService;
//    private final FirebaseService firebaseService;
//    private final SmsService smsService;
//    private final NotificationsRepository notificationsRepository;
//
//    @PostMapping("/send-email")
//    public ResponseEntity<Response> sendEmail(@RequestBody NotificationRequest notificationRequest) throws RuntimeException{
//        if (notificationRequest.isEmail()) {
//            Notification notification = new Notification();
//            notification.setContent(notificationRequest.getContent());
//            notification.setSubject(notificationRequest.getSubject());
//            notification.setRecipient(notificationRequest.getRecipient());
//            emailService.sendEmail(notification);
//        }
//        Notification notification = createNotification(notificationRequest);
//        notificationsRepository.save(notification);
//        return ResponseEntity.ok(new Response("Success","Email delivered"));
//    }
//    @GetMapping("/get-notifications/{recipientName}")
//    public List<Notification> getNotifications(@PathVariable String recipientName) {
//        List<Notification> notifications = notificationsRepository.findByRecipient_Name(recipientName);
//        return notifications;
//    }
//    @PostMapping("/send-firebase")
//    public ResponseEntity<Response> sendFirebaseNotification(@RequestBody NotificationRequest notificationRequest)throws FirebaseMessagingException {
//        if (notificationRequest.isPush()) {
//            firebaseService.sendFirebase(notificationRequest);
//        }
//        Notification notification = createNotification(notificationRequest);
//        notificationsRepository.save(notification);
//        return ResponseEntity.ok(new Response("Success","Notification delivered"));
//    }
//    @PostMapping("/send-sms")
//    public ResponseEntity<Response> sendSMSNotification( @RequestBody NotificationRequest notificationRequest) throws RuntimeException {
//        if (notificationRequest.isSMS()) {
//            smsService.sendSMS(notificationRequest);
//        }
//        Notification notification = createNotification(notificationRequest);
//        notificationsRepository.save(notification);
//        return ResponseEntity.ok(new Response("Success","SMS delivered"));
//    }
//    private Notification createNotification(NotificationRequest notificationRequest) {
//        Notification notification = new Notification();
//        notification.setContent(notificationRequest.getContent());
//        notification.setSubject(notificationRequest.getSubject());
//        notification.setRecipient(notificationRequest.getRecipient());
//        notification.setDateCreated(new Date());
//        notification.setEmail(notificationRequest.isEmail());
//        notification.setSMS(notificationRequest.isSMS());
//        notification.setPush(notificationRequest.isPush());
//        notification.setStatus("Sent"); // You can update the status as needed
//        return notification;
//    }
//}
