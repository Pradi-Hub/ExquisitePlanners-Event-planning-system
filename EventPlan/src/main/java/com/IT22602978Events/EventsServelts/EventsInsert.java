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





@WebServlet("/EventsInsert")
public class EventsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
		String Cxname=request.getParameter("Cxname");
		String phonenum=request.getParameter("Cxpnumber");
		String email=request.getParameter("Cxemail");
		String dateTimeString = request.getParameter("eventdateTime");
		String eventtype=request.getParameter("eventtype");
		String packagetype=request.getParameter("package");
		String specialrqst=request.getParameter("SpecialRqst");
		
		
		 String errorMessage = ""; 
		 // create the logger file instance 
		 EventLogger logger=EventLogger.getInstance();

	        
	        if (Cxname.isEmpty() || phonenum.isEmpty() || email.isEmpty() || dateTimeString.isEmpty() || eventtype.isEmpty() || packagetype.isEmpty()) {
	            errorMessage = "All fields are required.";
	        } else {
	        	// create the object to access the interface
	        	EventInterface eventDB = new EventinsertDB();
	            String isTrue = null;
				try {
					isTrue = eventDB.insertEvent(Cxname, phonenum, email, dateTimeString, eventtype, packagetype, specialrqst);
				} catch (Exception e) {
					
					e.printStackTrace();
					//call the logger file method
					logger.logExceptionWarning("An Error Exception occured(IsTrue)", e);
				}

	            if (!isTrue.equals("Event inserted successfully.")) {
	                errorMessage = isTrue; 
	            }
	        }

	        if (errorMessage.isEmpty()) {
	        try {
	        	
	        	request.setAttribute("eventDetails",EventinsertDB.generateReservationId(phonenum, email));
	        	//call the logger file method
	        	logger.logInfo("Event inserted successfully.");
	        }catch(Exception e) {
				e.printStackTrace();
				//call the logger file method
				logger.logExceptionWarning("An Error Exception occured(Generate reservation Id)", e);
			}
	            //directed to given file path
	        	RequestDispatcher dis1 = request.getRequestDispatcher("DamniduIT22602978/additional_data_form.jsp");
	            dis1.forward(request, response);
	           

	        } else {
	            
	            request.setAttribute("errorMessage", errorMessage);
	          //call the logger file method
	           logger.logWarning(errorMessage);
	            //directed to given file path
	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/unsuccess.jsp");
	            dis2.forward(request, response);
	        }
	}



}
