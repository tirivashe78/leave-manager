package zw.co.Afrosoft;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.Afrosoft.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Boolean existsByName(String name);

}
