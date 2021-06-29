package com.Admin.AdminService.Model;

import java.util.Date;

import javax.persistence.Id;

public class Bookticket {
private Integer bid;
private String name;
private String email;
private String bfrom;
private String bto;
private String arrival;
private String depature;
private Integer passesngers;
private String flightname;
private String coach;
private Date date;
private Integer price;
private Boolean status;
private String pnr;
public Integer getId() {
	return bid;
}
public void setId(Integer bid) {
	this.bid = bid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFrom() {
	return bfrom;
}
public void setFrom(String bfrom) {
	this.bfrom = bfrom;
}
public String getTo() {
	return bto;
}
public void setTo(String bto) {
	this.bto = bto;
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
public Integer getPassesngers() {
	return passesngers;
}
public void setPassesngers(Integer passesngers) {
	this.passesngers = passesngers;
}
public String getFlightname() {
	return flightname;
}
public void setFlightname(String flightname) {
	this.flightname = flightname;
}
public String getCoach() {
	return coach;
}
public void setCoach(String coach) {
	this.coach = coach;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public String getPnr() {
	return pnr;
}
public void setPnr(String pnr) {
	this.pnr = pnr;
}
public Object findAllBooktickets() {
	// TODO Auto-generated method stub
	return null;
}


}

