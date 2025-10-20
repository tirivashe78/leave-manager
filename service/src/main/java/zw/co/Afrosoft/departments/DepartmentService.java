package zw.co.Afrosoft.departments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.Afrosoft.dto.DepartmentRequest;
import zw.co.Afrosoft.entities.Department;

import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(DepartmentRequest departmentRequest);
    Department updateDepartment(long id, DepartmentRequest departmentRequest);
    Optional<Department> getDepartmentById(long id);
    Page<Department> getAllDepartments(Pageable pageable);
    Department deleteDepartment(long id);
}
