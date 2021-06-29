package com.Admin.AdminService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.Admin.AdminService.Model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
	//public Optional<Airline> findByName(String airlineName);
}