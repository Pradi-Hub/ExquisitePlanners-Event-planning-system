package com.IT22602978Events.EventsServelts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.IT22602978Events.EventClass.EventLogger;

import com.IT22602978Events.EventModels.EventinsertDB;
/**
 * Servlet implementation class HotelinfoInsert
 */
@WebServlet("/HotelinfoInsert")
public class HotelinfoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
			String reserveId=request.getParameter("reserveId");
			String hotelid=request.getParameter("hotel_id");
			String attendees=request.getParameter("attendees");
			String halltype=request.getParameter("halltype");
			String furthurdetails=request.getParameter("Specialrqst" );
			
			 String errorMessage = ""; 
			 // create the logger file instance
			 EventLogger logger=EventLogger.getInstance();  
			// create the object to access the interface  
			 EventinsertDB eventDB = new EventinsertDB();

		            String isTrue = null;
					try {
						isTrue = eventDB.insertInfo(reserveId, hotelid,attendees, halltype, furthurdetails);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.logExceptionWarning("An Error Exception occured(IsTrue-Hotel info)", e);
					}

		            if (!isTrue.equals("Event inserted successfully.")) {
		                errorMessage = isTrue; 
		            }
		        

		            if (errorMessage.isEmpty()) {
		            	try {
		    	        	request.setAttribute("eventDetails",reserveId);
		    	        	//call the logger file method
		    	        	logger.logInfo("Hotel Information inserted successfully.");
		    	        }catch(Exception e) {
		    				e.printStackTrace();
		    				//call the logger file method
		    				logger.logExceptionWarning("An Error Exception occured(reserve id-Hotel info)", e);
		    				
		    			} 
		            	//directed to given file path
		    	        	RequestDispatcher dis1 = request.getRequestDispatcher("DamniduIT22602978/additional_data_form.jsp");
		    	            dis1.forward(request, response);

		    	        } else {
		    	            
		    	            request.setAttribute("errorMessage", errorMessage);
		    	          //call the logger file method
		    	            logger.logWarning(errorMessage);
		    	            //directed to given file path
		    	            RequestDispatcher dis2 = request.getRequestDispatcher("DamniduIT22602978/unsuccess2.jsp");
		    	            dis2.forward(request, response);
		    	        }
		
		
		
		
		
		
		
	}

}
