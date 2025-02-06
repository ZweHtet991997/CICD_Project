package com.yomabank.employeeapiservices.mapper;

import com.yomabank.employeeapiservices.entity.EmployeeEntity;
import com.yomabank.employeeapiservices.model.EmployeeModel;

public class EntityMapper {
    public static EmployeeEntity ToEntity(EmployeeModel model) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setEmpCode(model.getEmpCode());
        entity.setPhoneNo(model.getPhoneNo());
        entity.setEmail(model.getEmail());
        entity.setDepartment(model.getDepartment());
        entity.setDivision(model.getDivision());
        return entity;
    }

    public static EmployeeModel ToModel(EmployeeEntity entity) {
        EmployeeModel model = new EmployeeModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmpCode(entity.getEmpCode());
        model.setDepartment(entity.getDepartment());
        model.setDivision(entity.getDivision());
        model.setDivision(entity.getDivision());
        model.setPhoneNo(entity.getPhoneNo());
        model.setEmail(entity.getEmail());
        return model;
    }
}
