package com.Admin.AdminService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Admin.AdminService.Model.Flight;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	@Query(value="SELECT a FROM Flight a WHERE a.ffrom = :ff and a.fto=:ft")
	List<Flight> findByFromAndTwo(@Param("ff") String ff, @Param("ft") String ft);
}
