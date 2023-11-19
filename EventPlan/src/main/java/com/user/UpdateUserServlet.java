package com.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logUtill.ReserveLogger;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Handling the doPost request for updating user information
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating a logger instance
		ReserveLogger logger = ReserveLogger.getInstance();
		// get parameters
		String id = request.getParameter("uid");
		String name = request.getParameter("name");
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String address = request.getParameter("address");
		String password = request.getParameter("psw");
		
		boolean isTrue;
		isTrue = UserDBUtil.updateuser(id, name, username, email, phone, nic, address, password);
		
		if(isTrue == true) {
			// Getting the updated user details and redirecting to the user view page
			List<User> userDetails = UserDBUtil.getUserDetails(id);
			request.setAttribute("userDetails", userDetails);
			logger.logInfo("User Profile Updated Sucessfully");// Logging the successful user profile update
			RequestDispatcher dis = request.getRequestDispatcher("userView.jsp");
			dis.forward(request, response);
		}
		else {
			// Redirecting to the user view page in case of an error
			List<User> userDetails = UserDBUtil.getUserDetails(id);
			request.setAttribute("userDetails", userDetails);
			logger.logWarning("Something wrong on server");// Logging a warning for server issues
			RequestDispatcher dis = request.getRequestDispatcher("userView.jsp");
			dis.forward(request, response);
		}
		
	}

}
