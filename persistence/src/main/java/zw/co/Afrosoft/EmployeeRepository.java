package zw.co.Afrosoft;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.Afrosoft.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
//    List<Employee> findByDepartment(String departmentName);
    List<Employee> findByEmployeeNameContainingIgnoreCase(String employeeName);
}
