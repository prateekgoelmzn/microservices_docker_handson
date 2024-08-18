package com.pg.redis_db_demo.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pg.redis_db_demo.model.Employee;

import java.util.Set;

public interface EmployeeSetRepo {
    public void addEmployeeToSet(Employee emp) throws JsonProcessingException;
    public Set<Employee> getAllEmployee();
}
