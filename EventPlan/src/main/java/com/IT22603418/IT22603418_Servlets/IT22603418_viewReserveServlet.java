package com.IT22603418.IT22603418_Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.IT22603418.IT22603418_javaclasses.IT22603418_Reservation;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReservationDetails;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;
import com.IT22603418.IT22603418_javaclasses.IT22603418_Services;
import com.IT22603418.IT22603418_models.IT22603418_ReservationDBUtil;

@WebServlet("/viewReserveServlet")
public class IT22603418_viewReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve reservation form data from the request
		String fullname = request.getParameter("fname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String date = request.getParameter("edate");
		String time = request.getParameter("etime");
		String location = request.getParameter("location");
		String Package = request.getParameter("Package");
		String guestcount = request.getParameter("count");
		String eventType = request.getParameter("type");
        String d1 = request.getParameter("decoration1");
        String d2 = request.getParameter("decoration2");
        String d3 = request.getParameter("decoration3");
        String photographers = request.getParameter("Photographers");
        String e1 = request.getParameter("Entertainments1");
        String e2 = request.getParameter("Entertainments2");
        String e3 = request.getParameter("Entertainments3");        
		String Splrequest = request.getParameter("Splrequest");
		//create logger object
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	

		boolean isTrue;
		// Instantiate a ReservationDB object
		IT22603418_Reservation ReservationDB = new IT22603418_ReservationDBUtil();
		// Insert reservation data into the database
		isTrue = ReservationDB.insertReservation(fullname, phone, email, date, time, location, Package, guestcount, eventType, d1, d2, d3, photographers, e1, e2, e3, Splrequest);		
		
		if(isTrue == true) {
			// If reservation insertion is successful, retrieve the reservation ID
			int Resid = ReservationDB.getResid(email);

			try {
				// Retrieve reservation details and services associated with the reservation
				List<IT22603418_ReservationDetails> resDetails = ReservationDB.validate(Resid);
				request.setAttribute("resDetails", resDetails);
				List<IT22603418_Services> serDetails = ReservationDB.iT22603418_Services(Resid);
				request.setAttribute("serDetails", serDetails);
				logger.logInfo("Reservation Inserted Successfully");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				// Forward the request to the "viewReserve.jsp" page
				RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_viewReserve.jsp");
				dis.forward(request, response);
		}else {
			logger.logWarning("Reservation not Inserted Successfully!!!");
			// If reservation insertion is not successful, forward to an "unsuccess.jsp" page
			RequestDispatcher dis2 = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
}


