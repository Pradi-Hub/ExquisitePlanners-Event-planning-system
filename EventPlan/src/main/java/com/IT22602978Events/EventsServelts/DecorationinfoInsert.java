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
 * Servlet implementation class DecorationinfoInsert
 */
@WebServlet("/DecorationinfoInsert")
public class DecorationinfoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get parameters from jsp
		String reserveId=request.getParameter("reserveId");
		String decorationid=request.getParameter("Decorator_id");
		String attendees=request.getParameter("attendees");
		String eventtype=request.getParameter("eventtype");
		String eventtheme=request.getParameter("eventtheme");
		String decorationstyle=request.getParameter("decorationstyle");
		String furthurdetails=request.getParameter("Specialrqst" );
		
		EventLogger logger=EventLogger.getInstance();
		
		 String errorMessage = ""; 

		// create the object to access the interface   
		 EventInterface eventDB = new EventinsertDB();

	            String isTrue = null;
				try {
					isTrue = eventDB.insertInfo(reserveId, decorationid,attendees, eventtype, furthurdetails,eventtheme,decorationstyle);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.logExceptionWarning("Error Exception occured (Decoration Info-isTrue): ", e);
				}

	            if (!isTrue.equals("Event inserted successfully.")) {
	                errorMessage = isTrue; 
	            }
	        

	            if (errorMessage.isEmpty()) {
	            	try {
	    	        	request.setAttribute("eventDetails",reserveId);
	    	        	logger.logInfo("Decoration Info Inserted Succefully");
	    	        }catch(Exception e) {
	    				e.printStackTrace();
	    				//call the logger file method
	    				logger.logExceptionWarning("Error Exception occured (Decoration Info -reserve id): ", e);
	    			} 
	            	//call the logger file method
	    	        	RequestDispatcher dis1 = request.getRequestDispatcher("DamniduIT22602978/additional_data_form.jsp");
	    	            dis1.forward(request, response);

	    	        } else {
	    	            
	    	            request.setAttribute("errorMessage", errorMessage);
	    	          //call the logger file method
	    	            logger.logWarning("Decoration Info Inserted Unsuccessful.");
	    	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/unsuccess2.jsp");
	    	            dis2.forward(request, response);
	    	        }

	}

}
