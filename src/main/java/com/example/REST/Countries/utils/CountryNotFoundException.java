package com.example.REST.Countries.utils;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(String message){
        super(message);
    }
}
