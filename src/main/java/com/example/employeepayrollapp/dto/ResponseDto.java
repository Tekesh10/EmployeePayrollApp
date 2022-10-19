package com.example.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ResponseDto {
    private String message;
    private Object data;
}