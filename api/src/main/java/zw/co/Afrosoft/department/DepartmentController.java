package zw.co.Afrosoft.department;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.Afrosoft.departments.DepartmentService;
import zw.co.Afrosoft.dto.DepartmentRequest;
import zw.co.Afrosoft.entities.Department;

import java.util.Optional;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@CrossOrigin
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<Department> create(@Valid @RequestBody DepartmentRequest departmentRequest) {
        Department createdDepartment = departmentService.createDepartment(departmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable long id,
                                                       @RequestBody DepartmentRequest departmentRequest) {
        Department updatedDepartment = departmentService.updateDepartment(id, departmentRequest);
        return ResponseEntity.ok(updatedDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<Department>> getAllDepartments(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Department> departments = departmentService.getAllDepartments(pageable);
        return ResponseEntity.ok(departments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable long id) {
        Department deletedDepartment = departmentService.deleteDepartment(id);
        return ResponseEntity.ok(deletedDepartment);
    }
}
