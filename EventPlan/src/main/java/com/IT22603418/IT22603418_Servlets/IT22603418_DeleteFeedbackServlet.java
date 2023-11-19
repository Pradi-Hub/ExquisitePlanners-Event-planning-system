package com.IT22603418.IT22603418_Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IT22603418.IT22603418_javaclasses.IT22603418_Contactinterface;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;
import com.IT22603418.IT22603418_models.IT22603418_ContactDBUtil;

@WebServlet("/DeleteFeedbackServlet")
public class IT22603418_DeleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the email parameter from the POST request
		String email = request.getParameter("email");
		// Create a logger instance
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	
		
		boolean isTrue;
		// Instantiate a ContactDB object
		IT22603418_Contactinterface ContactDB = new IT22603418_ContactDBUtil();
		// Retrieve the feedback ID (Fid) associated with the given email
		int Fid = ContactDB.getFid(email);
		// Delete the feedback using the feedback ID
		isTrue = ContactDB.deleteFeedback(Fid);
		
		if (isTrue == true) {
			// Log success and forward to the "FeedBack.jsp" page
			logger.logInfo("Feedback Deleted Successfully");
			RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_FeedBack.jsp");
			dis.forward(request, response);
		}else {
			// Log failure and forward to an "unsuccess.jsp" page
			logger.logWarning("Feedback not deleted Successfully!!!");
			RequestDispatcher dis2 = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
