package com.IT22602978Events.EventModels;

public interface EventInterface {

	// create the methods
    String insertEvent(String Cxname, String phonenum, String email, String dateTimeString, String eventtype, String packagetype, String specialrqst);
    String insertInfo();
    String insertInfo(String reserveId, String decorationid, String attendees, String eventtype, String furthurdetails,String eventtheme,String decorationstyle);
	String insertInfo(String reserveId, String cateringid, String attendees, String eventtype,
			String furthurdetails, String eventtheme, String fooditem, String platetype);
	String insertInfo2(String reserveId, String phographid,String attendees, String packagetype, String furthurdetails,String eventtheme, String videographer);
	 String updateEvent(String cusId,String cusName,String cusPnumber,String cusEmail,String datetime);
	 boolean deletereservation(String cusId);
}
