package com.pg.search_emp.repo;

import com.pg.search_emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    public List<Employee> findByFirstName(String firstName);
}
