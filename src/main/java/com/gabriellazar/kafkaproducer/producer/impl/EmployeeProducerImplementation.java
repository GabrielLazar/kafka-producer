package com.gabriellazar.kafkaproducer.producer.impl;

import com.gabriellazar.kafkaproducer.model.Employee;
import com.gabriellazar.kafkaproducer.producer.IEmployeeProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public class EmployeeProducerImplementation implements IEmployeeProducer {

    private KafkaTemplate<String, Employee> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    public EmployeeProducerImplementation(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(Employee employee) {

        if (employee.getFirstName() != null && employee.getLastName() != null) {
            String employeeKey = employee.getFirstName() + " " + employee.getLastName();
            ListenableFuture<SendResult<String, Employee>> employeeFuture = kafkaTemplate.send(topicName, employeeKey, employee);

            employeeFuture.addCallback(new ListenableFutureCallback<SendResult<String, Employee>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.error("Unable to deliver message [{}]. {}", employee, throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Employee> stringEmployeeSendResult) {
                    log.info("Successfully send employee :: {}", employee);
                }
            });
        } else {
            log.warn("Employee firstName or lastName is null :: {}", employee);
        }

    }
}
