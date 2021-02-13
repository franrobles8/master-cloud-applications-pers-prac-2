package com.mastercloudapps.airport.repository;

import java.util.List;

import com.mastercloudapps.airport.dto.TripulanteCiudadFechaDTO;
import com.mastercloudapps.airport.dto.TripulanteTiempoVueloAcumuladosDTO;
import com.mastercloudapps.airport.entity.Tripulante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripulanteRepository extends JpaRepository<Tripulante, String> {
    
    @Query("SELECT new com.mastercloudapps.airport.dto.TripulanteCiudadFechaDTO("
    + "t.nombre, t.apellidos, a.ciudad, v.fechaHora) "
    + "FROM Tripulante t JOIN VueloTripulante vt ON vt.tripulante = t JOIN Vuelo v ON vt.vuelo = v JOIN Aeropuerto a ON a.id = v.origen.id "
    + "WHERE t.codEmpleado = ?1")
    List<TripulanteCiudadFechaDTO> findTripulanteByCodEmpleado(String codEmpleado);
    
    @Query("SELECT new com.mastercloudapps.airport.dto.TripulanteTiempoVueloAcumuladosDTO(t.nombre,t.apellidos,COUNT(vt),SUM(v.duracion)) " +
                   "FROM Tripulante t JOIN VueloTripulante vt ON vt.tripulante = t JOIN Vuelo v ON vt.vuelo = v " +
                   "GROUP BY t.nombre, t.apellidos")
    List<TripulanteTiempoVueloAcumuladosDTO> findTripulanteTiempoVuelosAcumulados();

}
