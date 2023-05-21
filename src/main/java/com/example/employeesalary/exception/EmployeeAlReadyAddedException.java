package com.example.employeesalary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlReadyAddedException extends RuntimeException{
    public EmployeeAlReadyAddedException() {
    }

    public EmployeeAlReadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlReadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlReadyAddedException(Throwable cause) {
        super(cause);
    }

    public EmployeeAlReadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
