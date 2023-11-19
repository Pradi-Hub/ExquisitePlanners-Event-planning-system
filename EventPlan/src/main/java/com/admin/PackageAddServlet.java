// Import statements
package com.admin;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.user.DBConnect;

import logUtill.ReserveLogger;
//Servlet for adding a package
@WebServlet("/add_Packages")
@MultipartConfig
public class PackageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// doPost method for handling post requests
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Retrieving data
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
			Part pimg = request.getPart("pimg");
			String fileName = pimg.getSubmittedFileName();
			
			// Initializing the logger
			ReserveLogger logger = ReserveLogger.getInstance();
			// Creating a PackageDetails object
			PackageDetails p = new PackageDetails(packageName,venue,packagePrice,onePersonFoodprice,foodDesc,decoPkgs,decoDesc,entertainment,photographer,status,fileName);
			 // Initializing the PackageInterfaceImplement object
			PackageInterfaceImplement pi = new PackageInterfaceImplement(DBConnect.getConnection());
			// Adding packages to the database
			boolean f = pi.addPackages(p);
			HttpSession session = request.getSession();
			
			 // Handling the result of the package
			if(f) {
				// Storing the uploaded file in the appropriate directory
				String path = getServletContext().getRealPath("") + "packageImage";
				File file = new File(path);
				pimg.write(path + File.separator + fileName);
				// Setting success message and logging the success
				session.setAttribute("succMsg", "Package Added Sucessfully");
				logger.logInfo("Package Added Sucessfully");
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
