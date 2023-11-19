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
 * Servlet implementation class Photographinfo
 */
@WebServlet("/Photographinfo")
public class Photographinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
		String reserveId=request.getParameter("reserveId");
		String phographid=request.getParameter("Photographer_id");
		String attendees=request.getParameter("attendees");
		String packagetype=request.getParameter("packagetype");
		String eventtheme=request.getParameter("eventtheme");
		String videographer=request.getParameter("videographer");
		String furthurdetails=request.getParameter("Specialrqst" );
		
		 String errorMessage = ""; 
		 // create the logger file instance
		 EventLogger logger=EventLogger.getInstance();
		// create the object to access the interface  
		 EventInterface eventDB = new EventinsertDB();

	            String isTrue = null;
				try {
					isTrue = eventDB.insertInfo2(reserveId, phographid,attendees, packagetype, furthurdetails,eventtheme, videographer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//call the logger file method
					logger.logExceptionWarning("An Error Exception occured(IsTrue-Photography info)", e);
				}

	            if (!isTrue.equals("Event inserted successfully.")) {
	                errorMessage = isTrue; 
	            }
	        

	            if (errorMessage.isEmpty()) {
	            	try {
	    	        	request.setAttribute("eventDetails",reserveId);
	    	        	//call the logger file method
	    	        	logger.logInfo("Photography Information inserted successfully.");
	    	        }catch(Exception e) {
	    				e.printStackTrace();
	    				//call the logger file method
	    				logger.logExceptionWarning("An Error Exception occured(reserve id-Photography info)", e);
	    			} 
	            	//directed to given file path
	    	        	RequestDispatcher dis1 = request.getRequestDispatcher("DamniduIT22602978/additional_data_form.jsp");
	    	            dis1.forward(request, response);

	    	        } else {
	    	            
	    	            request.setAttribute("errorMessage", errorMessage);
	    	          //call the logger file method
	    	            logger.logWarning(errorMessage);
	    	            //directed to give file path
	    	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/unsuccess2.jsp");
	    	            dis2.forward(request, response);
	    	        }
	}

}
