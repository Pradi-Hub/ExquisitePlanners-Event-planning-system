package com.IT22603418.IT22603418_javaclasses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class IT22603418_ReservationDetails {
	private int Resid;
	private String fullname;
	private String phone;
	private String email;
	private LocalDate date;
	private LocalTime time;
	private String location;
	private String Package;
	private int guestcount;
	private String eventType;
	private String Splrequest;
	
	//constructor
	public IT22603418_ReservationDetails(int Resid, String fullname, String phone, String email, LocalDate date, LocalTime time,
			String location, String package1, int guestcount, String eventType, String Splrequest) {
		this.Resid = Resid;
		this.fullname = fullname;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.time = time;
		this.location = location;
		this.Package = package1;
		this.guestcount = guestcount;
		this.eventType = eventType;
		this.Splrequest = Splrequest;
	}
	
	//getters
	public int getResid() {
		return Resid;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getLocation() {
		return location;
	}

	public String getPackage() {
		return Package;
	}

	public int getGuestcount() {
		return guestcount;
	}

	public String getEventType() {
		return eventType;
	}

	public String getSplrequest() {
		return Splrequest;
	}

}
