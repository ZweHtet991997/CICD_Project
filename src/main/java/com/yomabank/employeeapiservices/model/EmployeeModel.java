package com.yomabank.employeeapiservices.model;

import lombok.Data;

@Data
public class EmployeeModel {
    private Integer id;
    private String empCode;
    private String name;
    private String email;
    private String phoneNo;
    private String department;
    private String division;
}
