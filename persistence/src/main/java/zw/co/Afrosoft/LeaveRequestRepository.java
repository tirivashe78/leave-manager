package zw.co.Afrosoft;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.Afrosoft.entities.LeaveRequest;

import java.util.List;
import java.util.Optional;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    Page<LeaveRequest> findAll(Pageable pageable);
    List<LeaveRequest> findByEmployeeId(long employeeId);
}
