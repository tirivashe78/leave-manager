package zw.co.Afrosoft;

import lombok.Data;
import zw.co.Afrosoft.enums.LeaveRequestType;

import java.time.LocalDate;

@Data
public class CreateLeaveRequestDto {
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String additionalInfo;
    private LeaveRequestType leaveRequestType;
}
