package zw.co.Afrosoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.Afrosoft.enums.LeaveRequestStatus;
import zw.co.Afrosoft.enums.LeaveRequestType;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "leaveRequest")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    private LeaveRequestStatus requestStatus;
    private String additionalInfo;
    @Enumerated(EnumType.STRING)
    private LeaveRequestType leaveRequestType;
    @ManyToOne
    @JoinColumn
    private Employee employee;
}
