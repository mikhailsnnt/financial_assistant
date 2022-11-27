package com.gb.tech.apioperation.exeptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AppError {
    private String statusCode;
    private String message;
}
