package com.workintech.proje18.exceptions;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException exception){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage(),exception.getStaus())
                return new ResponseEntity<>(burgerErrorResponse,exception.getMessage());

    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse>  handleAllExceptions(Exception exception){
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage(), exception.getCause());

    }

}
