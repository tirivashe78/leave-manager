package zw.co.Afrosoft.leaverequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.Afrosoft.CreateLeaveRequestDto;
import zw.co.Afrosoft.dto.LeaveRequestRequest;
import zw.co.Afrosoft.entities.LeaveRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leaveRequest")
@RequiredArgsConstructor
@CrossOrigin
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;
    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeaveRequestsByEmployee(@PathVariable Long employeeId) {
        return leaveRequestService.getLeaveRequestsByEmployeeId(employeeId);
    }

    @PutMapping("/approve/{leaveRequestId}")
    public LeaveRequest approveLeaveRequest(@PathVariable Long leaveRequestId) {
        return leaveRequestService.approveLeaveRequest(leaveRequestId);
    }

    @PutMapping("/reject/{leaveRequestId}")
    public LeaveRequest rejectLeaveRequest(@PathVariable Long leaveRequestId) {
        return leaveRequestService.rejectLeaveRequest(leaveRequestId);
    }

    @PostMapping("/create")
    public LeaveRequest createLeaveRequest(@RequestBody CreateLeaveRequestDto createLeaveRequestDto) {
        return leaveRequestService.createLeaveRequest(
                createLeaveRequestDto.getEmployeeId(),
                createLeaveRequestDto.getStartDate(),
                createLeaveRequestDto.getEndDate(),
                createLeaveRequestDto.getAdditionalInfo(),
                createLeaveRequestDto.getLeaveRequestType()
        );
    }


//    @PostMapping("/create")
//    public ResponseEntity<LeaveRequest> create(@Valid @RequestBody LeaveRequestRequest leaveRequestRequest) {
//        LeaveRequest leaveRequest = leaveRequestService.create(leaveRequestRequest);
//        return ResponseEntity.ok(leaveRequest);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> findById(@PathVariable long id) {
        LeaveRequest leaveRequest = leaveRequestService.findById(id);
        return ResponseEntity.ok(leaveRequest);
    }
//
    @GetMapping("")
    public ResponseEntity<Page<LeaveRequest>> getAllLeaveRequests(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests(pageable);
        return ResponseEntity.ok(leaveRequests);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LeaveRequest> deleteLeaveRequest(@PathVariable long id) {
        LeaveRequest leaveRequest = leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.ok(leaveRequest);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable long id,
//                                                           @RequestBody LeaveRequestRequest leaveRequestRequest) {
//        LeaveRequest leaveRequest = leaveRequestService.updateLeaveRequest(id, leaveRequestRequest);
//        return ResponseEntity.ok(leaveRequest);
//    }
//
//    @PostMapping("/approve")
//    public ResponseEntity<LeaveRequest> approveLeaveRequest(@RequestParam long employeeId,
//                                                            @RequestBody LeaveRequestRequest approvedRequest) {
//        LeaveRequest leaveRequest = leaveRequestService.approveLeaveRequest(employeeId, approvedRequest);
//        return ResponseEntity.ok(leaveRequest);
//    }
//
//    @PostMapping("/reject")
//    public ResponseEntity<LeaveRequest> rejectLeaveRequest(@PathVariable long employeeId,
//                                                           @RequestBody LeaveRequestRequest rejectedRequest) {
//        LeaveRequest leaveRequest = leaveRequestService.rejectLeaveRequest(employeeId, rejectedRequest);
//        return ResponseEntity.ok(leaveRequest);
//    }
//
//    @GetMapping("/employee/{employeeId}")
//    public ResponseEntity<List<LeaveRequest>> getLeaveRequestsByEmployeeId(@PathVariable long employeeId) {
//        List<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestsByEmployeeId(employeeId);
//        return ResponseEntity.ok(leaveRequests);
//    }

}
