package com.eduardofbom.query;

import com.eduardofbom.model.Address;
import com.eduardofbom.model.AddressViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepQuery {
    private String postalCode;

    public ViaCepQuery(String postalCode) {
        if (postalCode == null || (postalCode.length() != 8 && postalCode.length() != 10)) {
            throw new IllegalArgumentException("The postal code must contain 8 numbers.");
        }
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address query() {
        String uriAddres = "https://viacep.com.br/ws/" + postalCode + "/json/";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriAddres))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonQuery = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();
            AddressViaCep addressViaCep = gson.fromJson(jsonQuery, AddressViaCep.class);
            Address address = new Address(addressViaCep);

            return address;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
