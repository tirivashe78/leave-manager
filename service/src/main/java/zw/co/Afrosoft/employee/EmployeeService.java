package zw.co.Afrosoft.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import zw.co.Afrosoft.dto.EmployeeRequest;
import zw.co.Afrosoft.entities.Employee;

import java.security.Principal;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest);
    Page<Employee> getAll(Pageable pageable);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, EmployeeRequest employeeRequest);
    Employee deleteEmployee(Long id);
//    List<Employee> getEmployeesByDepartmentName(String departmentName);
    List<Employee> getEmployeesByName(String employeeName);
    Employee getProfile(Principal principal);
}
