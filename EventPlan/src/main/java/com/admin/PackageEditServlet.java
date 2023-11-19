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

@WebServlet("/edit_Packages")
public class PackageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtain an instance of the logger
		ReserveLogger logger = ReserveLogger.getInstance();
		try {
			// Extract values from the request parameters
			int id = Integer.parseInt(request.getParameter("id"));
			String packageName = request.getParameter("pname");
			String venue = request.getParameter("venue");
			String packagePrice = request.getParameter("packagePrice");
			String onePersonFoodprice = request.getParameter("onePersonFoodprice");
			String foodDesc = request.getParameter("foodDesc");
			String decoPkgs = request.getParameter("decoPkgs");
			String decoDesc = request.getParameter("decoDesc");
			String entertainment = request.getParameter("entertainment");
			String photographer = request.getParameter("photographer");
			String status = request.getParameter("status");
			// Create a PackageDetails object and set its properties
			PackageDetails p = new PackageDetails();
			
			p.setPackageID(id);
			p.setPackageName(packageName);
			p.setVenue(venue);
			p.setPackagePrice(packagePrice);
			p.setFoodPerPersonPrice(onePersonFoodprice);
			p.setFoodDescription(foodDesc);
			p.setDecorationPackage(decoPkgs);
			p.setDecorationDescription(decoDesc);
			p.setEntertainment(entertainment);
			p.setPhotographers(photographer);
			p.setStatus(status);
			
			// Initializing the PackageInterfaceImplement object
			PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());
			boolean f = pi.updatePackages(p);
			
			HttpSession session = request.getSession();
			
			if(f) {
				// Setting success message and logging the success
				session.setAttribute("succMsg", "Package Updated Sucessfully");
				logger.logInfo("Package Updated Sucessfully");
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
