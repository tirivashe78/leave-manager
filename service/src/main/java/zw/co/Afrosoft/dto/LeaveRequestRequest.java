package zw.co.Afrosoft.dto;

import com.google.firebase.database.annotations.NotNull;
import lombok.Data;
import zw.co.Afrosoft.enums.LeaveRequestStatus;
import zw.co.Afrosoft.enums.LeaveRequestType;

import java.time.LocalDate;

@Data
public class LeaveRequestRequest {
    @NotNull
    private Long employeeId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private LocalDate requestDate;
    @NotNull
    private LeaveRequestStatus requestStatus;
    private String additionalInfo;
    @NotNull
    private LeaveRequestType leaveRequestType;
}
