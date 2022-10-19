package com.example.employeepayrollapp.exception;

import com.example.employeepayrollapp.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class EmployeePayrollExceptionHandler {
    private static final String message = "Exception while processing REST Request";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentsNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto(message, errorMessage);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception) {
        ResponseDto responseDto = new ResponseDto(message,exception.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format", exception);
        ResponseDto responseDto = new ResponseDto(message, "Should have date in the Format dd MMM yyyy");
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}