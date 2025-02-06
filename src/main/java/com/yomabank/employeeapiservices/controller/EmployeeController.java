package com.yomabank.employeeapiservices.controller;

import com.yomabank.employeeapiservices.model.EmployeeModel;
import com.yomabank.employeeapiservices.service.EmployeeInterface;
import com.yomabank.employeeapiservices.utils.ResponseMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeInterface employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> CreateEmployee(@RequestBody EmployeeModel model) {
        String dataResult = employeeService.CreateEmployee(model);
        if (dataResult != ResponseMessageUtils.Success) {
            return ResponseEntity.badRequest().body(dataResult);
        }
        return ResponseEntity.ok().body(dataResult);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeModel>> CreateEmployee() {
        List<EmployeeModel> dataResult = employeeService.GetAllEmployee();
        return ResponseEntity.ok().body(dataResult);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> UpdateEmployee(@RequestBody EmployeeModel model) {
        String dataResult = employeeService.UpdateEmployee(model);
        if (dataResult != ResponseMessageUtils.Success) {
            return ResponseEntity.badRequest().body(dataResult);
        }
        return ResponseEntity.ok().body(dataResult);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> DeleteEmployee(@RequestParam Integer id) {
        String dataResult = employeeService.DeleteEmployee(id);
        return ResponseEntity.ok().body(dataResult);
    }
}
