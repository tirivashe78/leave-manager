package zw.co.Afrosoft.dto;

import lombok.Data;
import zw.co.Afrosoft.enums.UserRole;

@Data
public class UserDto {
private  long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
