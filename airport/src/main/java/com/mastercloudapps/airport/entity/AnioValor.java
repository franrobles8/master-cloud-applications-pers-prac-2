package com.mastercloudapps.airport.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnioValor {
    
    @Field("Anyo")
    private String anyo;

    @Field("Valor")
    private String valor;

}
