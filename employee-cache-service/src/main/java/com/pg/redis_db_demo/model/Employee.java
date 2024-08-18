package com.pg.redis_db_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    private Long id;
    private String firstName;
    private String lastName;
}
