package com.mastercloudapps.airport.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provincia {
    
    @Id
    @Field("_id")
    private String id;

    @Field("Nombre")
    private String nombre;

    @Field("CA")
    private String ca;

    @Field("Superficie")
    private Integer superficie;

    @Field("Datos")
    private List<AnioValor> datos;

}
