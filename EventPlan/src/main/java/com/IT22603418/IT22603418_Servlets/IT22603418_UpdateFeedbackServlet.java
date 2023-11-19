package com.IT22603418.IT22603418_Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.IT22603418.IT22603418_javaclasses.IT22603418_Contactinterface;
import com.IT22603418.IT22603418_javaclasses.IT22603418_FeedbackDetails;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;
import com.IT22603418.IT22603418_models.IT22603418_ContactDBUtil;

@WebServlet("/UpdateFeedbackServlet")
public class IT22603418_UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("remailu");
		int star = Integer.parseInt(request.getParameter("staru"));
		String message = request.getParameter("reviewu");
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	

		boolean isTrue;

		IT22603418_Contactinterface ContactDB = new IT22603418_ContactDBUtil();
		int Fid = ContactDB.getFid(email);

		isTrue = ContactDB.FeedbackUpdate(Fid, email, star, message);

		if (isTrue == true) {
			try {
				List<IT22603418_FeedbackDetails> feedDetails = ContactDB.view();
				//List<FeedbackDetails> feedDetails = ContactDB.validateFeedback(Fid);
				request.setAttribute("feedDetails", feedDetails);
				logger.logInfo("Feedback Updated Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_viewFeedback.jsp");
			dis.forward(request, response);
		} else {
			logger.logWarning("Feedback Updated Successfully!!!");
			RequestDispatcher dis2 = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
