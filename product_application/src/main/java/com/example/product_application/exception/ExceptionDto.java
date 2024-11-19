package com.example.product_application.exception;

import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
@Builder
public class ExceptionDto {
    String message;
    HttpStatus httpStatus;
}