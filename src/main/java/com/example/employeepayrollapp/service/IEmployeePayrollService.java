package com.example.employeepayrollapp.service;

import java.util.List;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.dto.EmployeePayrollDto;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    List<EmployeePayrollData> getEmployeeByDepartment(String department);
    EmployeePayrollData getEmployeePayrollDataById(int employeeId);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);
    EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto);
    void deleteEmployeePayrollData(int employeeId);
}