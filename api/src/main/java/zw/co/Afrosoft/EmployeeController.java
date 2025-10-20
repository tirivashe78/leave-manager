package zw.co.Afrosoft;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.Afrosoft.dto.EmployeeRequest;
import zw.co.Afrosoft.employee.EmployeeService;
import zw.co.Afrosoft.entities.Employee;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        Employee createdEmployee = employeeService.createEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/get-all")
    public Page<Employee> getAllEmployee(@RequestParam(defaultValue = "0") Integer pageNumber,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deletedEmployee);
    }
//    @GetMapping("/department")
//    public ResponseEntity<List<Employee>> getEmployeesByDepartmentName(@RequestParam String departmentName) {
//        List<Employee> employees = employeeService.getEmployeesByDepartmentName(departmentName);
//        return ResponseEntity.ok(employees);
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String employeeName) {
        List<Employee> employees = employeeService.getEmployeesByName(employeeName);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/profile")
    public ResponseEntity<Employee> getProfile(Principal principal) {
        Employee employee = employeeService.getProfile(principal);
        return ResponseEntity.ok(employee);
    }
}
