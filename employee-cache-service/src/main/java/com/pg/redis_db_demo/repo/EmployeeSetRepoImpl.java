package com.pg.redis_db_demo.repo;

import com.pg.redis_db_demo.constant.Constant;
import com.pg.redis_db_demo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class EmployeeSetRepoImpl implements EmployeeSetRepo {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final RedisTemplate<String, Employee> redisTemplate;
    private final RedisTemplate<String, Long> redisCounterTemplate;

    public EmployeeSetRepoImpl(RedisTemplate<String, Employee> redisTemplate, RedisTemplate<String, Long> redisCounterTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisCounterTemplate = redisCounterTemplate;
    }

    @Override
    public void addEmployeeToSet(Employee emp) {
        Long counterValue = getCounterValue();
        log.info("Counter value {} ",counterValue);
        emp.setId(counterValue);
        log.info("adding employee {} into redis set",emp.toString());
        this.redisTemplate.opsForSet().add(Constant.KEY, emp);
        incrementCounter();
    }

    @Override
    public Set<Employee> getAllEmployee() {
        return this.redisTemplate.opsForSet().members(Constant.KEY);
    }

    private void incrementCounter() {
        redisCounterTemplate.opsForValue().increment(Constant.COUNT_KEY);
    }

    private Long getCounterValue() {
        Long countValue = redisCounterTemplate.opsForValue().get(Constant.COUNT_KEY);
        if(countValue==null){
            redisCounterTemplate.opsForValue().set(Constant.COUNT_KEY,0L);
        }
        return redisCounterTemplate.opsForValue().get(Constant.COUNT_KEY);
    }
}
