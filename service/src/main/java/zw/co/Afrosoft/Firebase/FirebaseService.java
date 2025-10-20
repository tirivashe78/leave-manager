package zw.co.Afrosoft.Firebase;
import com.google.firebase.messaging.*;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import zw.co.Afrosoft.NotificationRequest;

@Service
@Resource
public class FirebaseService {
    private final FirebaseMessaging firebaseMessaging;
    public FirebaseService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }
@Async
    public String sendFirebase(NotificationRequest request) throws FirebaseMessagingException {

        Message message = Message
                .builder()
                .setNotification(new Notification(request.getSubject(), request.getContent()))
                .setToken(request.getRecipient().getFcmToken())
                .build();
        return firebaseMessaging.send(message);
    }
}

