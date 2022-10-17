package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;
import com.example.employeepayrollapp.dto.ResponseDto;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDto responseDto = new ResponseDto("Get All Call was Successful" ,employeePayrollDataList);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("employeeId") int employeeId){
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDto responseDto=new ResponseDto("Get Call For ID was Successful", employeePayrollData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Employee Payroll data created Successfully", employeePayrollData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("employeeId") int employeeId,@RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(employeeId, employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Employee Payroll data updated Successfully", employeePayrollData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId) {
        employeePayrollService.deleteEmployeePayrollData(employeeId);
        ResponseDto responseDto = new ResponseDto("Employee Payroll data deleted successfully","Deleted id: "+employeeId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}