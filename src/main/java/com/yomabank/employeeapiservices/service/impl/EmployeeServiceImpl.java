package com.yomabank.employeeapiservices.service.impl;

import com.yomabank.employeeapiservices.entity.EmployeeEntity;
import com.yomabank.employeeapiservices.mapper.EntityMapper;
import com.yomabank.employeeapiservices.model.EmployeeModel;
import com.yomabank.employeeapiservices.repo.EmployeeRepo;
import com.yomabank.employeeapiservices.service.EmployeeInterface;
import com.yomabank.employeeapiservices.utils.ResponseMessageUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeInterface {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String CreateEmployee(EmployeeModel model) {
        if (CheckEmailDuplicate(model.getEmail())) {
            return ResponseMessageUtils.EmailDuplicate(model.getEmail());
        } else if (CheckEmpCodeDuplicate(model.getEmpCode())) {
            return ResponseMessageUtils.EmpCodeDuplicate(model.getEmpCode());
        }
        EmployeeEntity dataResult = employeeRepo.save(EntityMapper.ToEntity(model));
        return ResponseMessageUtils.Success;
    }

    private boolean CheckEmailDuplicate(String email) {
        try {
            EmployeeEntity checkEmail = employeeRepo.findByEmail(email);
            if (checkEmail != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean CheckEmpCodeDuplicate(String empCode) {
        try {
            EmployeeEntity checkEmpCode = employeeRepo.findByEmpCode(empCode);
            if (checkEmpCode != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmployeeModel> GetAllEmployee() {
        List<EmployeeModel> lstEmployee = new ArrayList<>();
        List<EmployeeEntity> employees = employeeRepo.findAll();

        for (EmployeeEntity employee : employees) {
            lstEmployee.add(EntityMapper.ToModel(employee));
        }
        return lstEmployee;
    }

    @Override
    public String UpdateEmployee(EmployeeModel model) {

        EmployeeEntity dataResult = employeeRepo.findById(model.getId()).get();

        if (dataResult.getId() > 0) {
            if (CheckEmailDuplicate(model.getEmail())) {
                return ResponseMessageUtils.EmailDuplicate(model.getEmail());
            } else if (CheckEmpCodeDuplicate(model.getEmpCode())) {
                return ResponseMessageUtils.EmpCodeDuplicate(model.getEmpCode());
            }
            // Update fields only if they are not null
            if (model.getName() != null) {
                dataResult.setName(model.getName());
            }
            if (model.getEmail() != null) {
                dataResult.setEmail(model.getEmail());
            }
            if (model.getEmpCode() != null) {
                dataResult.setEmpCode(model.getEmpCode());
            }
            if (model.getPhoneNo() != null) {
                dataResult.setPhoneNo(model.getPhoneNo());
            }
            if (model.getDepartment() != null) {
                dataResult.setDepartment(model.getDepartment());
            }
            if (model.getDivision() != null) {
                dataResult.setDivision(model.getDivision());
            }

            // Save the updated entity
            employeeRepo.save(dataResult);
            return ResponseMessageUtils.Success;
        }
        return ResponseMessageUtils.BadRequest;
    }

    @Override
    public String DeleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
        return ResponseMessageUtils.Success;
    }
}
