package zw.co.Afrosoft;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String subject;
    @Embedded
    private Recipient recipient;
    private String status;
    private Date dateCreated;
    private boolean isEmail;
    private boolean isSMS;
    private boolean isPush;

}
