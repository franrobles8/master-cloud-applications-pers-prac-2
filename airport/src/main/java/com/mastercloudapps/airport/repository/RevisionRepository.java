package com.mastercloudapps.airport.repository;

import com.mastercloudapps.airport.entity.Revision;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
    
}
