package com.workintech.proje18.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BurgerException extends  RuntimeException{
    private HttpStatus httpStatus;

    public BurgerException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
}
