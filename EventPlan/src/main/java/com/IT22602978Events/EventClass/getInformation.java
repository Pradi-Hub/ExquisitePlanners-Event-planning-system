package com.IT22602978Events.EventClass;

//Define the getInformation class
public class getInformation {
	 // Declare private instance variables to store reservation information
	private int reservationsid;
	private String fulllname;
	private String phonenum;
	private String email;
	private String datetime;
	private String eventtype;
	private String packagetype;
	private String specialrqst;
	
	 // Constructor for the getInformation class
	public getInformation(int reservationsid, String fulllname, String phonenum, String email, String datetime,
			String eventtype, String packagetype, String specialrqst) {
		// Initialize the instance variables with the provided values
		this.reservationsid = reservationsid;
		this.fulllname = fulllname;
		this.phonenum = phonenum;
		this.email = email;
		this.datetime = datetime;
		this.eventtype = eventtype;
		this.packagetype = packagetype;
		this.specialrqst = specialrqst;
	}
	 // Getter methods to retrieve the values of the instance variables
	public int getReservationsid() {
		return reservationsid;
	}
	public String getFulllname() {
		return fulllname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public String getEmail() {
		return email;
	}
	public String getDatetime() {
		return datetime;
	}
	public String getEventtype() {
		return eventtype;
	}
	public String getPackagetype() {
		return packagetype;
	}
	public String getSpecialrqst() {
		return specialrqst;
	}

	

}
