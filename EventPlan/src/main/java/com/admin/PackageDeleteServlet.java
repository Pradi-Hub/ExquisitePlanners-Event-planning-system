// Import statements
package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.DBConnect;

import logUtill.ReserveLogger;
//Servlet for deleting a package
@WebServlet("/delete")
public class PackageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Handling GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating an instance of the ReserveLogger
		ReserveLogger logger = ReserveLogger.getInstance();

		try {
			// Getting the package ID to be deleted
			int id = Integer.parseInt(request.getParameter("pid"));
			// Initializing the PackageInterfaceImplement object
			PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());
			boolean f = pi.deletePackages(id);

			HttpSession session = request.getSession();
			// Handling the result of the package deletion
			if (f) {
				// Setting success message and logging the success
				session.setAttribute("succMsg", "Package Deleted Sucessfully");
				logger.logInfo("Package Deleted Sucessfully");
				response.sendRedirect("admin/allPackages.jsp");
			} else {
				// Setting failure message and logging the warning
				session.setAttribute("failedMsg", "Something wrong on server");
				logger.logWarning("Something wrong on server");
				response.sendRedirect("admin/allPackages.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
