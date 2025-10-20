package zw.co.Afrosoft;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Recipient {
    private  String name;
    private  String phoneNumber;
    private String email;
    private  String fcmToken;
}
