package com.pg.scheduler.service;

import com.pg.scheduler.constant.Constant;
import com.pg.scheduler.dto.Employee;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class DataExtractService {

    final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private RedisTemplate<String, Employee> redisTemplate;

    public Set<Employee> extract() {
        long size = Optional.ofNullable(this.redisTemplate.opsForSet().size(Constant.KEY)).orElse(0L);
        if (size != 0) {
            return this.redisTemplate.opsForSet().members(Constant.KEY);
        }
        return Collections.emptySet();
    }

    public void clearRedisSet(Employee emp) {
        if (this.redisTemplate.opsForSet().isMember(Constant.KEY,emp)) {
            log.info("Deleting {} ....",emp.toString());
            this.redisTemplate.opsForSet().remove(Constant.KEY,emp);
        }
    }
}
