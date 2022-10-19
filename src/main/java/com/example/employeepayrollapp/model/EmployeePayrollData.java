package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@NoArgsConstructor
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePicture;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;
    public EmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        this.updateEmployeePayrollData(employeePayrollDto);
    }
    public void updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.gender = employeePayrollDto.gender;
        this.startDate = employeePayrollDto.startDate;
        this.note = employeePayrollDto.note;
        this.profilePicture = employeePayrollDto.profilePicture;
        this.department = employeePayrollDto.department;
    }
}