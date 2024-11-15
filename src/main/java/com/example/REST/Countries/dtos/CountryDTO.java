package com.example.REST.Countries.dtos;

import com.example.REST.Countries.dtos.countriesDtos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class CountryDTO {

    private Name name;
    private List<String> tld;
    private String cca2;
    private String cca3;
    private String ccn3;
    private String cioc;
    private boolean independent;
    private String subregion;
    private String region;
    private Map<String, String> languages;
    private Map<String, TranslationDTO> translations;
    private String flag;
    private List<Double> latlng;
    private String demonym;
    private double area;
    private long population;
    private Map<String, Currency> currencies;
    private CoatOfArms coatOfArms;
}
