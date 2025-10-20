package zw.co.Afrosoft.dto;

import lombok.Data;
import zw.co.Afrosoft.enums.UserRole;
@Data
public class AuthenticationResponse {

    private String jwt;
    private long userId;
    private UserRole userRole;
    private boolean success;
    private String message;
}
