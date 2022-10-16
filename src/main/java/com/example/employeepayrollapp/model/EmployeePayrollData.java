package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;

public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private double salary;
    public EmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
        this.employeeId = employeeId;
        this.name = employeePayrollDto.getName();
        this.salary = employeePayrollDto.getSalary();
    }
    public EmployeePayrollData() {
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(Long salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}