package com.IT22602978Events.EventClass;

//Import statements for required classes or packages

//Define the Catering_Info class, which extends getInformation
public class Catering_Info extends getInformation {
	// Private field to store the number of attendees
	    private int attendees;
	 // Constructor for Catering_Info class
	    public Catering_Info(int reservationsid, String eventtype, int attendees) {
	    	 // Call the constructor of the parent class (getInformation) using 'super'
	        super(reservationsid, null, null, null, null, eventtype, null, null);
	     // Initialize the 'attendees' field with the provided value
	        this.attendees = attendees;
	    }
	    // Getter method to retrieve the number of attendees
	    public int getAttendees() {
	        return attendees;
	    }
	
	
}
