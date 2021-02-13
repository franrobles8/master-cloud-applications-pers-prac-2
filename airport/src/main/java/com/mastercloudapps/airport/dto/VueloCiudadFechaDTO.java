package com.mastercloudapps.airport.dto;

import java.util.Date;

import com.mastercloudapps.airport.entity.Aeropuerto;
import com.mastercloudapps.airport.entity.Avion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueloCiudadFechaDTO {

    private Long id;

    private String codVuelo;

    private String compania;

    private Avion avion;

    private Aeropuerto origen;

    private Aeropuerto destino;

    private Date fechaHora;

    private Double duracion;
    
}
