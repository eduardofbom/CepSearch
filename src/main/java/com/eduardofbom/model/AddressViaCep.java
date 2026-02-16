package com.eduardofbom.model;

public record AddressViaCep(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String estado,
        String regiao,
        String ddd
) {}
