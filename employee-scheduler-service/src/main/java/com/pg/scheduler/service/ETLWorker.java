package com.pg.scheduler.service;

import com.pg.scheduler.dto.Employee;
import com.pg.scheduler.entity.EmployeeEntity;
import com.pg.scheduler.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ETLWorker {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private DataExtractService dataExtractService;
    private EmployeeRepo repo;

    @Scheduled(fixedRate = 5000)
    public void run(){
        log.info("Running ETL worker....");

        // extract
        Set<Employee> employees = dataExtractService.extract();
        log.info("Fetch {} records from  redis set",employees.size());

        // load into db
        employees.forEach(employee -> {
            var empEntity = new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName());
            log.info("Saving Employee in postgress db");
            repo.save(empEntity);
            dataExtractService.clearRedisSet(employee);
        });

        // clear data from redis
        log.info("clearing data from redis set");
    }
}
