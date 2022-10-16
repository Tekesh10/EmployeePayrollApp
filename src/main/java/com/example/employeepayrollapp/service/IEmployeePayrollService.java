package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;
import com.example.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int employeeId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);
    EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto);
    void deleteEmployeePayrollData(int employeeId);
}