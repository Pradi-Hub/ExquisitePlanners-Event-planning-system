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
 * Servlet implementation class DeleteReservation
 */
@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from jsp
		String cusId=request.getParameter("CxId");
		
		EventLogger logger=EventLogger.getInstance();
		
		boolean isTrue;
		// create the object to access the interface  
		EventInterface eventDB = new EventinsertDB();
		isTrue=eventDB.deletereservation(cusId);
		
		if(isTrue==true) {
			//get the values from get information class
			List<getInformation>AllEventDetails=EventinsertDB.AllEventView();
        	
			request.setAttribute("AlleventDetails1",AllEventDetails);
			//call the logger file method
			logger.logInfo("Event Deleted Successfully.");
			//directed to given file path
			RequestDispatcher dis2 =request.getRequestDispatcher("DamniduIT22602978/dashboard.jsp");
    		dis2.forward(request, response);
		}else {
			//get the values from get information class
			List<getInformation>EventDetails=EventinsertDB.Eventcheck(cusId);
			//copy the details
			request.setAttribute("eventDetails",EventDetails);
			//call the logger file method
			logger.logWarning("Event Deletion Unsuccefull.");
			//directed to given file path
			RequestDispatcher dis2 =request.getRequestDispatcher("DamniduIT22602978/ViewEvent.jsp");
    		dis2.forward(request, response);
		}
	}

}
