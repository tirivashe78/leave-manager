//package zw.co.Afrosoft;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//import zw.co.Afrosoft.Email.EmailService;
////import zw.co.Afrosoft.sms.SmsService;
//
//@RestController
//@RequestMapping("/notifications")
//@RequiredArgsConstructor
//public class NotificationController {
//    private final EmailService emailService;
////    private final FirebaseService firebaseService;
////    private final SmsService smsService;
//    private final NotificationsRepository notificationsRepository;
//
//    @PostMapping("/send-notifications")
//    public ResponseEntity<Response> sendNotifications(@RequestBody NotificationRequest notificationRequest) throws RuntimeException, FirebaseMessagingException {
//        Notification notification = createNotification(notificationRequest);
//        if (notificationRequest.isEmail()) {
//            emailService.sendEmail(notification);
//        }
////        if (notificationRequest.isPush()) {
////            firebaseService.sendFirebase(notificationRequest);
////        }
////        if (notificationRequest.isSMS()) {
////            smsService.sendSMS(notificationRequest);
////        }
//        notificationsRepository.save(notification);
//        return ResponseEntity.ok(new Response("Success", "Notifications delivered"));
//    }
//    @GetMapping("/get-notifications/{recipientName}")
//    public List<Notification> getNotifications(@PathVariable String recipientName) {
//        List<Notification> notifications = notificationsRepository.findByRecipient_Name(recipientName);
//        return notifications;
//    }
//
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
