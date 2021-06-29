package com.Admin.AdminService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.AdminService.Model.Airline;
import com.Admin.AdminService.Repository.AirlineRepository;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:4200"},maxAge = 3000)
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AirlineController {
	@Autowired
	private AirlineRepository service;

	@GetMapping("/airlines")
	public ResponseEntity<List<Airline>> findAll(){
		List<Airline> airlines = this.service.findAll();
		ResponseEntity<List<Airline>> response =
				new ResponseEntity<List<Airline>>(airlines, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/airlines/{airlineId}")
	public ResponseEntity<Airline> findById(@PathVariable Integer airlineId){
		Optional<Airline> airline = this.service.findById(airlineId);
		Airline airlineObj = airline.map(airl -> airl).orElse(new Airline());
		ResponseEntity<Airline> response =
				new ResponseEntity<Airline>(airlineObj, HttpStatus.OK);
		return response;
	}
	@GetMapping("/airlines1/{contactNumber}")
	public ResponseEntity<Airline> findById1(@PathVariable Integer contactNumber){
		Optional<Airline> airline = this.service.findById(contactNumber);//select * from airline where id=5
		Airline airlineObj = airline.map(airl -> airl).orElse(new Airline());
		ResponseEntity<Airline> response =
				new ResponseEntity<Airline>(airlineObj, HttpStatus.OK);
		return response;
	}
	
	/*
	 * @GetMapping("/airlines/{airlineName}") public ResponseEntity<Airline>
	 * findByNAME(@PathVariable String airlineName) { Optional<Airline> airline =
	 * this.service.findByName(airlineName); Airline airlineObj = airline.map(airl
	 * -> airl).orElse(new Airline()); ResponseEntity<Airline> response = new
	 * ResponseEntity<Airline>(airlineObj, HttpStatus.OK); return response; }
	 */
	
	@PostMapping("/airlines")
	public ResponseEntity<Airline> add(@RequestBody Airline airline){
		Airline airlineRes = this.service.save(airline);
		ResponseEntity<Airline> response =
				new ResponseEntity<Airline>(airlineRes, HttpStatus.OK);
		return response;
	}

	
	@PutMapping("/airlines")
	public ResponseEntity<Airline> update(@RequestBody Airline airline){
		Airline airlineRes = this.service.save(airline);
		ResponseEntity<Airline> response =
				new ResponseEntity<Airline>(airlineRes, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/airlines/{airlineId}")
	public ResponseEntity<Airline> delete(@PathVariable Integer airlineId){
		 this.service.deleteById(airlineId);
		ResponseEntity<Airline> response =
				new ResponseEntity<Airline>( HttpStatus.OK);
		return response;
	}
	
}

