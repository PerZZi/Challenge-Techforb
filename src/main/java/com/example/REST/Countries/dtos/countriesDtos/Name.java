package com.example.REST.Countries.dtos.countriesDtos;

import lombok.Getter;

import java.util.Map;

@Getter
public class Name {

    private String official;
    private String common;
    private Map<String,Object> nativeName;
}
