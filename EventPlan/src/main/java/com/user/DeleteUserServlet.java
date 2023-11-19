package com.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Handling the doPost request for deleting a user
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		try {
			String id = request.getParameter("uid");// Extracting the user ID from the request

			boolean isTrue;
			isTrue = UserDBUtil.deleteUser(id);// Deleting the user from the database
			// Redirecting to the appropriate page based on the deletion success or failure
			if (isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("registration.jsp");
				dis.forward(request, response);
			} else {
				List<User> userDetails = UserDBUtil.getUserDetails(id);
				request.setAttribute("userDetails", userDetails);

				RequestDispatcher dis2 = request.getRequestDispatcher("userView.jsp");
				dis2.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}