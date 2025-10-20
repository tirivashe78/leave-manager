package zw.co.Afrosoft.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeName;
    @ManyToOne
    private Department department;
    private String employeeNumber;
    private String jobTitle;
    private String address;
    private String email;
    private String phoneNumber;
    private String gender;
    private String surname;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany
    private List<LeaveRequest> leaveRequests;
}
