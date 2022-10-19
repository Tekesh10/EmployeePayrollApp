package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeePayrollRepository.findById(employeeId).orElseThrow(() -> new EmployeePayrollException("Employee with Employee Id"+employeeId+" does Not Exists"));
    }
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = new EmployeePayrollData(employeePayrollDto);
        log.debug("Employee Data -> "+ employeePayrollData);
        return employeePayrollRepository.save(employeePayrollData);
    }
    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(employeePayrollData);
    }
    public void deleteEmployeePayrollData(int employeeId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollRepository.delete(employeePayrollData);
    }
    @Override
    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }
}