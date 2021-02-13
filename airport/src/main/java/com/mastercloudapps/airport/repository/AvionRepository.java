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

}
