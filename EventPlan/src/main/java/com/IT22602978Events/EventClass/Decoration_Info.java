package com.IT22602978Events.EventClass;
//Import statements can go here if needed
//Define the Decoration_Info class, which extends the getInformation class
public class Decoration_Info extends getInformation{
	// Declare private instance variables  
	private int attendees;	 // Stores the number of attendees
	    private String specialrqst;// Stores special requests for decoration

	 // Constructor for the Decoration_Info class
	    public Decoration_Info(int reservationsid, String eventtype, int attendees, String specialrqst) {
	    	// Call the constructor of the parent class using 'super'
	        super(reservationsid, null, null, null, null, eventtype, null, null);
	        this.attendees = attendees; // Initialize the 'attendees' variable
	        this.specialrqst = specialrqst;// Initialize the 'specialrqst' variable
	    }

	 // Getter method for retrieving the number of attendees
	    public int getAttendees() {
	        return attendees;
	    }
	 // Getter method for retrieving special decoration requests
	    public String getSpecialrqst() {
	        return specialrqst;
	    }
	
	
	
	
}
