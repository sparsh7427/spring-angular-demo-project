package com.employee.department.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {

    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private DepartmentDTO department;
}
