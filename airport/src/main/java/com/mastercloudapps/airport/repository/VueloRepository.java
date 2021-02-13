package com.mastercloudapps.airport.repository;

import java.util.Date;
import java.util.List;

import com.mastercloudapps.airport.dto.VueloCiudadFechaDTO;
import com.mastercloudapps.airport.entity.Vuelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    @Query("SELECT new com.mastercloudapps.airport.dto.VueloCiudadFechaDTO("
    + "v.id, v.codVuelo, v.compania, v.avion, v.origen, v.destino, v.fechaHora, v.duracion) "
    + "FROM Vuelo v, Aeropuerto a WHERE v.destino = a AND a.ciudad = ?1 AND DATE(v.fechaHora) = DATE(?2) "
    + "ORDER BY v.fechaHora ASC")
    List<VueloCiudadFechaDTO> findVuelosByCiudadDestinoAndFechaOrderedByHour(String ciudad, @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date fecha);

}
