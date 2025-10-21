//package zw.co.Afrosoft.leaverequest;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import zw.co.Afrosoft.EmployeeRepository;
//import zw.co.Afrosoft.Exceptions.RecordNotFoundException;
//import zw.co.Afrosoft.LeaveRequestRepository;
//import zw.co.Afrosoft.dto.LeaveRequestRequest;
//import zw.co.Afrosoft.entities.Employee;
//import zw.co.Afrosoft.entities.LeaveRequest;
//import zw.co.Afrosoft.enums.LeaveRequestStatus;
//import zw.co.Afrosoft.enums.LeaveRequestType;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class LeaveRequestServiceImpl implements LeaveRequestService{
//    @Autowired
//    private LeaveRequestRepository leaveRequestRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
////    private JavaMailSender javaMailSender;
//
//    @Override
//    public List<LeaveRequest> getLeaveRequestsByEmployeeId(Long employeeId) {
//        return leaveRequestRepository.findByEmployeeId(employeeId);
//    }
//
//    @Override
//    @Transactional
//    public LeaveRequest approveLeaveRequest(Long leaveRequestId) {
//        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
//                .orElseThrow(() -> new RuntimeException("Leave request not found"));
//        leaveRequest.setRequestStatus(LeaveRequestStatus.APPROVED);
//        sendEmail(leaveRequest.getEmployee().getEmail(), "Leave Request Approved", "Your leave request has been approved.");
//        return leaveRequest;
//    }
//
//    @Override
//    @Transactional
//    public LeaveRequest rejectLeaveRequest(Long leaveRequestId) {
//        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
//                .orElseThrow(() -> new RuntimeException("Leave request not found"));
//        leaveRequest.setRequestStatus(LeaveRequestStatus.REJECTED);
//        sendEmail(leaveRequest.getEmployee().getEmail(), "Leave Request Rejected", "Your leave request has been rejected.");
//        return leaveRequest;
//    }
//
//    @Override
//    @Transactional
//    public LeaveRequest createLeaveRequest(Long employeeId, LocalDate startDate, LocalDate endDate, String additionalInfo, LeaveRequestType leaveRequestType) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        LeaveRequest leaveRequest = LeaveRequest.builder()
//                .startDate(startDate)
//                .endDate(endDate)
//                .requestDate(LocalDate.now())
//                .requestStatus(LeaveRequestStatus.PENDING)
//                .additionalInfo(additionalInfo)
//                .leaveRequestType(LeaveRequestType.PERSONAL_LEAVE)
//                .employee(employee)
//                .build();
//
//        leaveRequest = leaveRequestRepository.save(leaveRequest);
//
//        sendEmail(employee.getEmail(), "Leave Request Submitted", "Your leave request has been submitted successfully.");
//        return leaveRequest;
//    }
//
//    private void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
////        javaMailSender.send(message);
//    }
//
////    @Autowired
////    private LeaveRequestRepository leaveRequestRepository;
////
////    @Autowired
////    private EmployeeRepository employeeRepository;
////
////    @Autowired
////    private JavaMailSender emailSender;
////
////    @Override
////    public LeaveRequest create(LeaveRequestRequest leaveRequestRequest) {
////        Employee employee = employeeRepository.findById(leaveRequestRequest.getEmployeeId())
////                .orElseThrow(() -> new RecordNotFoundException("Employee not found"));
////
////        LeaveRequest leaveRequest = LeaveRequest.builder()
////                .employee(employee)
////                .startDate(leaveRequestRequest.getStartDate())
////                .endDate(leaveRequestRequest.getEndDate())
////                .requestDate(leaveRequestRequest.getRequestDate())
////                .requestStatus(leaveRequestRequest.getRequestStatus())
////                .additionalInfo(leaveRequestRequest.getAdditionalInfo())
////                .leaveRequestType(leaveRequestRequest.getLeaveRequestType())
////                .build();
////
////        return leaveRequestRepository.save(leaveRequest);
////    }
////
//    @Override
//    public LeaveRequest findById(long id) {
//        return leaveRequestRepository.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException("Leave request not found"));
//    }
////
//    @Override
//    public Page<LeaveRequest> getAllLeaveRequests(Pageable pageable) {
//        return leaveRequestRepository.findAll(pageable);
//    }
////
//    @Override
//    public LeaveRequest deleteLeaveRequest(long id) {
//        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
//                .orElseThrow(() -> new RecordNotFoundException("Leave request not found"));
//        leaveRequestRepository.delete(leaveRequest);
//        return leaveRequest;
//    }
////
////    @Override
////    public LeaveRequest updateLeaveRequest(long id, LeaveRequestRequest leaveRequestRequest) {
////        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
////                .orElseThrow(() -> new RecordNotFoundException("Leave request not found"));
////
////        Employee employee = employeeRepository.findById(leaveRequestRequest.getEmployeeId())
////                .orElseThrow(() -> new RecordNotFoundException("Employee not found"));
////
////        leaveRequest.setEmployee(employee);
////        leaveRequest.setStartDate(leaveRequestRequest.getStartDate());
////        leaveRequest.setEndDate(leaveRequestRequest.getEndDate());
////        leaveRequest.setRequestDate(leaveRequestRequest.getRequestDate());
////        leaveRequest.setRequestStatus(leaveRequestRequest.getRequestStatus());
////        leaveRequest.setAdditionalInfo(leaveRequestRequest.getAdditionalInfo());
////        leaveRequest.setLeaveRequestType(leaveRequestRequest.getLeaveRequestType());
////
////        return leaveRequestRepository.save(leaveRequest);
////    }
////    @Override
////    @Transactional
////    public LeaveRequest approveLeaveRequest(long id, LeaveRequestRequest approvedRequest) {
////        LeaveRequest leaveRequest = updateLeaveRequest(id, approvedRequest);
////        String employeeEmail = leaveRequest.getEmployee().getEmail();
////        sendEmail(employeeEmail, "Leave Request Approved", "Your leave request has been approved.");
////        return leaveRequest;
////    }
////
////    @Override
////    @Transactional
////    public LeaveRequest rejectLeaveRequest(long id, LeaveRequestRequest rejectedRequest) {
////        LeaveRequest leaveRequest = updateLeaveRequest(id, rejectedRequest);
////        String employeeEmail = leaveRequest.getEmployee().getEmail();
////        sendEmail(employeeEmail, "Leave Request Rejected", "Your leave request has been rejected.");
////        return leaveRequest;
////    }
////
////    @Override
////    public List<LeaveRequest> getLeaveRequestsByEmployeeId(long employeeId) {
////        return leaveRequestRepository.findByEmployeeId(employeeId);
////    }
////
////    private void sendEmail(String to, String subject, String body) {
////        SimpleMailMessage message = new SimpleMailMessage();
////        message.setTo(to);
////        message.setSubject(subject);
////        message.setText(body);
////        emailSender.send(message);
////    }
//}
