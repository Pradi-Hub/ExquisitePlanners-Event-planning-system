package com.IT22602978Events.EventsServelts;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IT22602978Events.EventClass.EventLogger;
import com.IT22602978Events.EventClass.getInformation;
import com.IT22602978Events.EventModels.EventInterface;
import com.IT22602978Events.EventModels.EventinsertDB;

/**
 * Servlet implementation class UpdateEventDetails
 */
@WebServlet("/UpdateEventDetails")
public class UpdateEventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
		String cusid=request.getParameter("cusid");
		String cusName=request.getParameter("Cxname");
		String cusPnumber=request.getParameter("Cxpnumber");
		String cusEmail=request.getParameter("Cxemail");
		String datetime=request.getParameter("eventdateTime");
		
		// create the object using logger file 
		EventLogger logger=EventLogger.getInstance(); 
		  
		String errorMessage = "";
	     // create the object to access the database model
	        	EventInterface eventDB = new EventinsertDB();
	            String isTrue = null;
				try {
					isTrue = eventDB.updateEvent(cusid, cusName, cusPnumber, cusEmail, datetime);
				} catch (Exception e) {
					
					e.printStackTrace();
					//call the logger file method
					logger.logExceptionWarning("An Error Exception occured(IsTrue-Update Event info)", e);
				}

	            if (!isTrue.equals("Event inserted successfully.")) {
	                errorMessage = isTrue; 
	            }
	        

	        if (errorMessage.isEmpty()) {
	        
	        	try {
	        	List<getInformation>EventDetails=EventinsertDB.Eventcheck(cusid);
	    		request.setAttribute("eventDetails",EventDetails);
	        	}catch(Exception e) {
	        		e.printStackTrace();
	        		//call the logger file method
    				logger.logExceptionWarning("An Error Exception occured(Event check-Update Event info)", e);
	        	}
	        	//call the logger file method
	        	logger.logInfo("Event  Information updated successfully.");
	    		// directed to the given file path
	    		RequestDispatcher dis2 =request.getRequestDispatcher("DamniduIT22602978/ViewEvent.jsp");
	    		dis2.forward(request, response);
	           

	        } else {
	            
	            request.setAttribute("errorMessage", errorMessage);
	          //call the logger file method
	            logger.logWarning(errorMessage);
	            // directed to give file path
	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/Unsuccess3.jsp");
	            dis2.forward(request, response);
	        }
		
		
	}

}
