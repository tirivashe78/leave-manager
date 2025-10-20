package zw.co.Afrosoft.dto;

import lombok.Data;

@Data
public class DepartmentRequest {

    private String name;
    private int maxNumberOfLeaveDays;
    private String description;
}
