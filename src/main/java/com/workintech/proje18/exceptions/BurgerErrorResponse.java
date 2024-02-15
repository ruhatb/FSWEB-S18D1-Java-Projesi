package com.workintech.proje18.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BurgerErrorResponse {

    private  String message;
    private Integer staus;

    private long timestap;

    public BurgerErrorResponse(String message, Integer staus) {
        this.message=message;
        this.staus=staus;
    }
}



