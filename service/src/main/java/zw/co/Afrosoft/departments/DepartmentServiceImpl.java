package zw.co.Afrosoft.departments;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.Afrosoft.DepartmentRepository;
import zw.co.Afrosoft.Exceptions.FileAlreadyExistsException;
import zw.co.Afrosoft.Exceptions.RecordNotFoundException;
import zw.co.Afrosoft.dto.DepartmentRequest;
import zw.co.Afrosoft.entities.Department;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department createDepartment(DepartmentRequest departmentRequest) {
        if (departmentRepository.existsByName(departmentRequest.getName())) {
            throw new FileAlreadyExistsException("Department with name " + departmentRequest.getName() + " already exists.");
        }

        Department department = Department.builder()
                .name(departmentRequest.getName())
                .description(departmentRequest.getDescription())
                .maxNumberOfLeaveDays(departmentRequest.getMaxNumberOfLeaveDays())
                .build();

        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    public Department updateDepartment(long id, DepartmentRequest departmentRequest) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Department not found with id " + id));
        if (departmentRepository.existsByName(departmentRequest.getName())) {
            throw new FileAlreadyExistsException("Department with name " + departmentRequest.getName() + " already exists.");
        }

        existingDepartment.setName(departmentRequest.getName());
        existingDepartment.setDescription(departmentRequest.getDescription());
        existingDepartment.setMaxNumberOfLeaveDays(departmentRequest.getMaxNumberOfLeaveDays());



        return departmentRepository.save(existingDepartment);
    }

    @Override
    public Optional<Department> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Department deleteDepartment(long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Department not found with id " + id));

        departmentRepository.delete(department);
        return department;
    }

}
