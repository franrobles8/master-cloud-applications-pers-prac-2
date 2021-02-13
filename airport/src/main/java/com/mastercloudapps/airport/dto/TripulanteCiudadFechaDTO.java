package com.mastercloudapps.airport.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripulanteCiudadFechaDTO {

    private String nombre;

    private String apellidos;

    private String ciudadDespegue;

    private Date fechaDespliegue;

}