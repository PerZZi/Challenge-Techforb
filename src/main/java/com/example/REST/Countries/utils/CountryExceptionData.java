package com.example.REST.Countries.utils;

public class CountryExceptionData extends RuntimeException{

    public CountryExceptionData(String message){
        super(message);
    }

    public CountryExceptionData(String message, Throwable cause) {
        super(message, cause);
    }
}
