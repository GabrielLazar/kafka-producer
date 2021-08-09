package com.gabriellazar.kafkaproducer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private Long jobId;
    private BigDecimal salary;
    private Long managerId;
    private Long departmentId;
}
