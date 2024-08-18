package com.pg.search_emp.controller;

import com.pg.search_emp.entity.Employee;
import com.pg.search_emp.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class SearchEmpController {

    EmployeeRepo empRepo;

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> findEmployeesByFirstName(@RequestParam(value = "firstname",required = true) String firstname){
        List<Employee> employeeList = empRepo.findByFirstName(firstname);
        return ResponseEntity.ok(employeeList);
    }
}
