package com.mastercloudapps.airport.repository;

import com.mastercloudapps.airport.entity.Aeropuerto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    
}
