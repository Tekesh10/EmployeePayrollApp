package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    private final List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeePayrollDataList.get(employeeId - 1);
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size() + 1, employeePayrollDto);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollData.setName(employeePayrollDto.getName());
        employeePayrollData.setSalary((long) employeePayrollDto.getSalary());
        employeePayrollDataList.set(employeeId -1, employeePayrollData);
        return employeePayrollData;
    }
    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        employeePayrollDataList.remove(employeeId -1);
    }
}