package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logUtill.ReserveLogger;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Handling the doPost request for user login
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating a logger instance
		ReserveLogger logger = ReserveLogger.getInstance();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// get parameters
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");

		boolean isTrue;
		isTrue = UserDBUtil.validate(username, password); // Validating the user credentials

		if (isTrue) {
			// Retrieving user details for display
			List<User> userDetails = UserDBUtil.getCustomer(username);
			request.setAttribute("userDetails", userDetails);

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			// Redirecting to the appropriate page based on the user role
			if ("admin2000".equals(username)) {
				logger.logInfo("Redirect to the Admin Page");
				RequestDispatcher adminDis = request.getRequestDispatcher("admin/adminView.jsp");
				adminDis.forward(request, response);
			}else if ("Supplier2000".equals(username)) {
				logger.logInfo("Redirect to the Supplier Page");
				RequestDispatcher supplierDis = request.getRequestDispatcher("SupplierView.jsp");
				supplierDis.forward(request, response);
			} else if ("eventadmin2000".equals(username)) {
				RequestDispatcher supplierDis = request.getRequestDispatcher("Home_page_IT22602978.jsp");
				supplierDis.forward(request, response);
			} else {
				RequestDispatcher dis = request.getRequestDispatcher("Home_page_IT22603418.jsp");
				dis.forward(request, response);
			}

		} else {
			// Displaying an alert in case of incorrect username or password
			logger.logWarning("Something wrong on server");
			out.println("<script type='text/javascript'>");
			out.println("alert('Your User Name or Password is Incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}

	}

}
