package zw.co.Afrosoft;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.Afrosoft.entities.User;
import zw.co.Afrosoft.enums.UserRole;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String username);

    Optional<User> findByUserRole(UserRole userRole);
}
