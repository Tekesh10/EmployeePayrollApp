package com.example.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class EmployeePayrollAppApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EmployeePayrollAppApplication.class, args);
        log.info("Employee Payroll App is now Running", applicationContext.getEnvironment().getProperty("environment"));
    }
}