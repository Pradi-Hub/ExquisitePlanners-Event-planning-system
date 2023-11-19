package com.IT22602978Events.EventsServelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IT22602978Events.EventClass.EventLogger;
import com.IT22602978Events.EventModels.EventInterface;
import com.IT22602978Events.EventModels.EventinsertDB;



/**
 * Servlet implementation class CateringInfo
 */
@WebServlet("/CateringInfo")
public class CateringInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
		String reserveId=request.getParameter("reserveId");
		String cateringid=request.getParameter("catering_id");
		String attendees=request.getParameter("attendees");
		String eventtype=request.getParameter("eventtype");
		String eventtheme=request.getParameter("eventtheme");
		String fooditem=request.getParameter("fooditem");
		String platetype=request.getParameter("platetype");
		String furthurdetails=request.getParameter("Specialrqst" );
		
		// create the object to access the logger file 
		EventLogger logger=EventLogger.getInstance();
		
		 String errorMessage = ""; 

	       // create the object to access the interface  
		 EventInterface eventDB = new EventinsertDB();

	            String isTrue = null;
				try {
					isTrue = eventDB.insertInfo(reserveId, cateringid,attendees, eventtype, furthurdetails,eventtheme,fooditem,platetype);
				} catch (Exception e) {
					
					e.printStackTrace();
					logger.logExceptionWarning("An Error Exception occured(IsTrue-catering info)", e);
				}

	            if (!isTrue.equals("Event inserted successfully.")) {
	                errorMessage = isTrue; 
	            }
	        

	            if (errorMessage.isEmpty()) {
	            	try {
	            		 // Set an attribute to store event details for the JSP
	            		
	    	        	request.setAttribute("eventDetails",reserveId);
	    	        	logger.logInfo("Catering Information inserted successfully.");
	    	        }catch(Exception e) {
	    				e.printStackTrace();
	    				//call the logger file method
	    				logger.logExceptionWarning("An error exception (catering info reserve id):", e);;
	    			} 
	            	// direct to the given file path
	    	        	RequestDispatcher dis1 = request.getRequestDispatcher("DamniduIT22602978/additional_data_form.jsp");
	    	            dis1.forward(request, response);

	    	        } else {
	    	            
	    	            request.setAttribute("errorMessage", errorMessage);
	    	          //call the logger file method
	    	            logger.logWarning(errorMessage);
	    	         // direct to the given file path
	    	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/unsuccess2.jsp");
	    	            dis2.forward(request, response);
	    	        }

	}

}
