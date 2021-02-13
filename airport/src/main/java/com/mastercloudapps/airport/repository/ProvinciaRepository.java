package com.mastercloudapps.airport.repository;

import java.util.List;

import com.mastercloudapps.airport.dto.ComunidadAutonomaNProvinciasDTO;
import com.mastercloudapps.airport.entity.Provincia;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {
    
    @Aggregation("{ $group: { _id: { $ifNull: [ $CA, 'Sin Comunidad' ] }, numProvincias: { $sum: 1 } } }")
    List<ComunidadAutonomaNProvinciasDTO> findAllCAsAndCountProvinces();

}
