package com.gabriellazar.kafkaproducer.producer;

import com.gabriellazar.kafkaproducer.model.Employee;

public interface IEmployeeProducer {
    void sendMessage(Employee employee);
}
