package com.Admin.AdminService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.AdminService.Model.Bookticket;
import com.Admin.AdminService.Model.Flight;
import com.Admin.AdminService.Repository.FlightRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {
	@Autowired
	private FlightRepository flightService;
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper mapper = new ObjectMapper();

	//private Object flightService;
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> findAll(){
		List<Flight> flights = this.flightService.findAll();
		ResponseEntity<List<Flight>> response =
				new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/confirmticket")
	public void send(@RequestBody Bookticket ticket) throws Exception {
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ticket);
			this.kafkaTemplate.send("tickettopic", json);

	}
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> findById(@PathVariable Integer flightId){
		Optional<Flight> flight = this.flightService.findById(flightId);
		Flight flightObj = flight.map(fli -> fli).orElse(new Flight());
		ResponseEntity<Flight> response =
				new ResponseEntity<Flight>(flightObj, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/searchflights/{ff}/str/{ft}")
	public ResponseEntity<List<Flight>> findById(@PathVariable String ff,@PathVariable String ft){
		System.out.println(ff+ft);
		List<Flight> flight = this.flightService.findByFromAndTwo(ff,ft);
		ResponseEntity<List<Flight>> response =
				new ResponseEntity<List<Flight>>(flight, HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/flightsforprice/{flightId}")
//	public ResponseEntity<Double> findprice(@PathVariable Integer flightId){
//		Double flight = this.flightService.findOneforPrice(flightId);
////		Flight flightObj = flight.map(fli -> fli).orElse(new Flight());
//		System.out.println("@@"+flight);
//		ResponseEntity<Double> response =
//				new ResponseEntity<Double>(flight, HttpStatus.OK);
//		return response;
//	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> add(@RequestBody Flight flight){
		Flight flightRes = this.flightService.save(flight);
		ResponseEntity<Flight> response =
				new ResponseEntity<Flight>(flightRes, HttpStatus.OK);
		return response;
	}

	
	@PutMapping("/flights")
	public ResponseEntity<Flight> update(@RequestBody Flight flight){
		Flight flightRes = this.flightService.save(flight);
		ResponseEntity<Flight> response =
				new ResponseEntity<Flight>(flightRes, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity<Flight> delete(@PathVariable Integer flightId){
		this.flightService.deleteById(flightId);
		ResponseEntity<Flight> response =
				new ResponseEntity<Flight>( HttpStatus.OK);
		return response;
	}
	
}

