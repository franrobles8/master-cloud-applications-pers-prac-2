package com.mastercloudapps.airport.repository;

import java.util.List;

import com.mastercloudapps.airport.dto.AvionRevisionMecanicoDTO;
import com.mastercloudapps.airport.entity.Avion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvionRepository extends JpaRepository<Avion, Long> {
    
    @Query("SELECT DISTINCT new com.mastercloudapps.airport.dto.AvionRevisionMecanicoDTO("
            + "r.avion.id as avionId, m.nombre, m.apellidos"
            + ") FROM Avion a INNER JOIN Revision r ON r.avion = a INNER JOIN Mecanico m ON r.mecanico = m "
            + "ORDER BY avionId")
    List<AvionRevisionMecanicoDTO> findAllAvionesByMecanicosAndRevisiones();

    @Query("SELECT new com.mastercloudapps.airport.dto.AvionRevisionMecanicoDTO(" 
			+ "a.id, m.nombre, m.apellidos)" 
			+ "FROM Mecanico m "
			+ "JOIN Avion a ON FUNCTION("
				+ "'JSON_CONTAINS',"
				+ "FUNCTION('JSON_EXTRACT', a.jsonRevisiones, '$[*].mecanico'),"
				+ "CONVERT(m.id, JSON)) = 1")
    List<AvionRevisionMecanicoDTO> findAllAvionesByMecanicosAndRevisionesJson();

}
