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

import com.IT22602978Events.EventModels.EventinsertDB;

/**
 * Servlet implementation class ViewEvent
 */
@WebServlet("/ViewEvent")
public class ViewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the values from jsp
		String reserveId=request.getParameter("reserveId");
		
		//create the logger file object
		EventLogger logger=EventLogger.getInstance();
		
		try {
		
		
		// get the values from get information class	
		List<getInformation>EventDetails=EventinsertDB.Eventcheck(reserveId);
		request.setAttribute("eventDetails",EventDetails);
		
		
		//directed to given file path
		RequestDispatcher dis2 =request.getRequestDispatcher("DamniduIT22602978/ViewEvent.jsp");
		dis2.forward(request, response);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			//call the logger file method
			logger.logExceptionWarning("An Error Exception occured(specified  event view-View Event)", e);
		}
	}

}
