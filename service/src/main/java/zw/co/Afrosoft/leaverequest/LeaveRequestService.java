//package zw.co.Afrosoft.leaverequest;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import zw.co.Afrosoft.dto.LeaveRequestRequest;
//import zw.co.Afrosoft.entities.LeaveRequest;
//import zw.co.Afrosoft.enums.LeaveRequestType;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//public interface LeaveRequestService {
////    LeaveRequest create(LeaveRequestRequest leaveRequestRequest);
////
//    LeaveRequest findById(long id);
////
//    Page<LeaveRequest> getAllLeaveRequests(Pageable pageable);
////
//    LeaveRequest deleteLeaveRequest(long id);
////
////    LeaveRequest updateLeaveRequest(long id, LeaveRequestRequest leaveRequestRequest);
////
////    LeaveRequest approveLeaveRequest(long employeeId, LeaveRequestRequest approvedRequest);
////
////    LeaveRequest rejectLeaveRequest(long employeeId, LeaveRequestRequest rejectedRequest);
////
////    List<LeaveRequest> getLeaveRequestsByEmployeeId(long employeeId);
//List<LeaveRequest> getLeaveRequestsByEmployeeId(Long employeeId);
//    LeaveRequest approveLeaveRequest(Long leaveRequestId);
//    LeaveRequest rejectLeaveRequest(Long leaveRequestId);
//    LeaveRequest createLeaveRequest(Long employeeId, LocalDate startDate, LocalDate endDate, String additionalInfo, LeaveRequestType leaveRequestType);
//}
