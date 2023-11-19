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
 * Servlet implementation class ViewAllEvents
 */
@WebServlet("/ViewAllEvents")
public class ViewAllEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//create the logger file object
		EventLogger logger=EventLogger.getInstance();
		try {
			
			// get the information from get information class
			List<getInformation>AllEventDetails=EventinsertDB.AllEventView();
        	
			request.setAttribute("AlleventDetails1",AllEventDetails);
		
		
		// directed to given file path
		RequestDispatcher dis =request.getRequestDispatcher("DamniduIT22602978/dashboard.jsp");
		dis.forward(request, response);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			//call the logger file method
			logger.logExceptionWarning("An Error Exception occured(All evnt view-View All Events)", e);
		}
	}

}
