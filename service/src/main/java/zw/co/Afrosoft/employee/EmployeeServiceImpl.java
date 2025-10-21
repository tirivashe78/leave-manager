package zw.co.Afrosoft.employee;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.Afrosoft.DepartmentRepository;
//import zw.co.Afrosoft.Email.MailService;
import zw.co.Afrosoft.EmployeeRepository;
import zw.co.Afrosoft.Exceptions.FileAlreadyExistsException;
import zw.co.Afrosoft.Exceptions.RecordNotFoundException;
import zw.co.Afrosoft.dto.EmployeeRequest;
import zw.co.Afrosoft.entities.Department;
import zw.co.Afrosoft.entities.Employee;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
//    private final MailService emailService;

    @Override
    @Transactional
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        if (employeeRepository.findByEmail(employeeRequest.getEmail()).isPresent()) {
            throw new FileAlreadyExistsException("Employee with email " + employeeRequest.getEmail() + " already exists.");
        }

        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));

        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setDepartment(department);
        employee.setEmployeeNumber(employeeRequest.getEmployeeNumber());
        employee.setJobTitle(employeeRequest.getJobTitle());
        employee.setAddress(employeeRequest.getAddress());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.setGender(employeeRequest.getGender());
        employee.setSurname(employeeRequest.getSurname());
        Employee savedEmployee = employeeRepository.save(employee);

        // Send email notification
//        emailService.sendEmail(employee.getEmail(), "Welcome to the Company", "Dear " + employee.getEmployeeName() + ", your account has been created successfully.");

        return savedEmployee;
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee not found with id " + id));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee not found with id " + id));

        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid department ID"));

        existingEmployee.setEmployeeName(employeeRequest.getEmployeeName());
        existingEmployee.setDepartment(department);
        existingEmployee.setEmployeeNumber(employeeRequest.getEmployeeNumber());
        existingEmployee.setJobTitle(employeeRequest.getJobTitle());
        existingEmployee.setAddress(employeeRequest.getAddress());
        existingEmployee.setEmail(employeeRequest.getEmail());
        existingEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        existingEmployee.setGender(employeeRequest.getGender());
        existingEmployee.setSurname(employeeRequest.getSurname());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee not found with id " + id));
        employeeRepository.delete(employee);
        return employee;
    }
//    @Override
//    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
//        return employeeRepository.findByDepartmentContainingIgnoreCase(departmentName);
//    }

    @Override
    public List<Employee> getEmployeesByName(String employeeName) {
        return employeeRepository.findByEmployeeNameContainingIgnoreCase(employeeName);
    }

    @Override
    public Employee getProfile(Principal principal) {
        return employeeRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new RecordNotFoundException("Employee not found with email " + principal.getName()));
    }
}
