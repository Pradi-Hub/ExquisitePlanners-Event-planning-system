package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logUtill.ReserveLogger;

@WebServlet("/insert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creating a logger instance
		ReserveLogger logger = ReserveLogger.getInstance();
		// get parameters
		String name = request.getParameter("name");
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String address = request.getParameter("address");
		String password = request.getParameter("psw");
		
		boolean isTrue;
		// Inserting user data into the database
		isTrue = UserDBUtil.insertuser(name, username, email, phone, nic, address, password);
		// Handling the results of the database operation and logging accordingly
		if(isTrue == true) {
			logger.logInfo("User Insert Sucessfully");
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}
		else {
			logger.logWarning("Something wrong on server");
			RequestDispatcher dis2 = request.getRequestDispatcher("registration.jsp");
			dis2.forward(request, response);
		}
	}

}
