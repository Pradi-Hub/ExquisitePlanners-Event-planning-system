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


@WebServlet("/contactUsServlet")
public class IT22603418_contactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();		
		
		boolean isTrue;
		
		IT22603418_Contactinterface ContactDB = new IT22603418_ContactDBUtil();
		
		isTrue = ContactDB.contactUsInsert(name, email, message);
		
		if (isTrue == true) {
			logger.logInfo("Contact form Inserted Successfully");
			RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_ContactUsView.jsp");
			dis.forward(request, response);
			
		}else {
			logger.logWarning("Contact form not Inserted Successfully!!!");
			RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
