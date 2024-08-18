package com.pg.redis_db_demo.controller;

import com.pg.redis_db_demo.model.Employee;
import com.pg.redis_db_demo.repo.EmployeeSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class AppController {

    @Autowired
    EmployeeSetRepo repo;

    @PostMapping("/save")
    ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
        try {
            repo.addEmployeeToSet(emp);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error while saving employee details");
        }
        return ResponseEntity.ok("Successful");
    }
}
