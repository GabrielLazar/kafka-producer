package com.gabriellazar.kafkaproducer.service.impl;

import com.gabriellazar.kafkaproducer.model.Employee;
import com.gabriellazar.kafkaproducer.producer.IEmployeeProducer;
import com.gabriellazar.kafkaproducer.repository.EmployeeRepository;
import com.gabriellazar.kafkaproducer.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;
    private IEmployeeProducer employeeProducer;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, IEmployeeProducer employeeProducer) {
        this.employeeRepository = employeeRepository;
        this.employeeProducer = employeeProducer;
    }

    @Override
    public void processEmployee() {
        LocalDateTime localDateTime = LocalDateTime.now();

        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(employeeProducer::sendMessage);

        long executionTime = localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS);
        log.info("Send employee data took :: {} millis", executionTime);
    }


}
