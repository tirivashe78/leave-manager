package zw.co.Afrosoft.auth;

import zw.co.Afrosoft.dto.SignupRequest;
import zw.co.Afrosoft.dto.UserDto;

public interface AuthService {
    UserDto signupUser(SignupRequest signupRequest);
    boolean hasUserWithEmail(String email);
}
