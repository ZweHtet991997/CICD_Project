package com.yomabank.employeeapiservices.repo;

import com.yomabank.employeeapiservices.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByEmail(String email);

    EmployeeEntity findByEmpCode(String empCode);
}
