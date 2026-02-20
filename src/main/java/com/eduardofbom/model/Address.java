package com.eduardofbom.model;

import com.eduardofbom.exception.PostalCodeNotFoundException;

import java.nio.file.ProviderNotFoundException;

public class Address {
    private String postalCode;
    private String thoroughfare;
    private String neighborhood;
    private String city;
    private String state;
    private String region;
    private String areaCode;

    public Address(String postalCode,
                   String thoroughfare,
                   String neighborhood,
                   String city,
                   String state,
                   String region,
                   String areaCode) {
        if (postalCode.equals("null")) {
            throw new PostalCodeNotFoundException("Postal code not found.");
        }
        this.postalCode = postalCode;
        this.thoroughfare = thoroughfare;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.region = region;
        this.areaCode = areaCode;
    }

    public Address(AddressViaCep addressViaCep) {
        this.postalCode = addressViaCep.cep();
        this.thoroughfare = addressViaCep.logradouro();
        this.neighborhood = addressViaCep.bairro();
        this.city = addressViaCep.localidade();
        this.state = addressViaCep.estado();
        this.region = addressViaCep.regiao();
        this.areaCode = addressViaCep.ddd();
    }

    public String getPostalCode() {
        return postalCode;
    }
    public String getThoroughfare() {
        return thoroughfare;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getRegion() {
        return region;
    }
    public String getAreaCode() {
        return areaCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", thoroughfare='" + thoroughfare + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", region='" + region + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
