package com.yomabank.employeeapiservices.service;

import com.yomabank.employeeapiservices.model.EmployeeModel;

import java.util.List;

public interface EmployeeInterface {
    String CreateEmployee(EmployeeModel model);

    List<EmployeeModel> GetAllEmployee();

    String UpdateEmployee(EmployeeModel model);

    String DeleteEmployee(Integer id);
}
