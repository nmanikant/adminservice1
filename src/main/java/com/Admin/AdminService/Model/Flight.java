package com.Admin.AdminService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
//	@Column(name = "flightid", unique = true, nullable = false)
	@GeneratedValue
	private Integer flightid;
	
	private String ffrom;
	private String fto;
	private String arrival;
	private String depature;
	private Double price;
	private Integer seats;
	private String airlines;
	
	
	public Integer getFlightId() {
		return flightid;
	}
	public void setFlightId(Integer flightId) {
		this.flightid = flightId;
	}
	
	public String getFfrom() {
		return ffrom;
	}
	public void setFfrom(String ffrom) {
		this.ffrom = ffrom;
	}
	public String getFto() {
		return fto;
	}
	public void setFto(String fto) {
		this.fto = fto;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	

}

