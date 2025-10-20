package zw.co.Afrosoft.dto;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeName;
    private Long departmentId; // Assuming you have a Department entity with an ID
    private String employeeNumber;
    private String jobTitle;
    private String address;
    private String email;
    private String phoneNumber;
    private String gender;
    private String surname;
}
