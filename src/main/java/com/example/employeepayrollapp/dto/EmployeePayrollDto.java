package com.example.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public @ToString class EmployeePayrollDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name Can't be Null")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public double salary;
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "start date should not be Empty")
    @PastOrPresent(message = "start date should not be future date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotBlank(message = "Profile picture cannot be Empty")
    public String profilePicture;
    @NotNull(message = "Department should not be Empty")
    public List<String> department;
}