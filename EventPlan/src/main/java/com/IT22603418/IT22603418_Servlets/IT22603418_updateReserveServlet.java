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

@WebServlet("/updateReserveServlet")
public class IT22603418_updateReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve reservation form data from the request
		String fullname = request.getParameter("fnameu");
		String phone = request.getParameter("phoneu");
		String email = request.getParameter("emailu");
		String date = request.getParameter("edateu");
		String time = request.getParameter("etimeu");
		String location = request.getParameter("locationu");
		String Package = request.getParameter("Packageu");
		String guestcount = request.getParameter("countu");
		String eventType = request.getParameter("typeu");
        String d1 = request.getParameter("decoration1u");
        String d2 = request.getParameter("decoration2u");
        String d3 = request.getParameter("decoration3u");
        String photographers = request.getParameter("Photographersu");
        String e1 = request.getParameter("Entertainments1u");
        String e2 = request.getParameter("Entertainments2u");
        String e3 = request.getParameter("Entertainments3u");        
		String Splrequest = request.getParameter("Splrequestu");
		// Create a logger object
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	
		
		boolean isTrue, isTrue2;
		// Instantiate a ReservationDB object
		IT22603418_Reservation ReservationDB = new IT22603418_ReservationDBUtil();
		
		int Resid = ReservationDB.getResid(email);
		// Insert reservation data into the database
		isTrue = ReservationDB.updateReservation(Resid, fullname, phone, email, date, time, location, Package, guestcount, eventType, Splrequest);
		
		if (isTrue == true) {
			// If reservation insertion is successful, retrieve the reservation ID
			isTrue2 = ReservationDB.updateServices(Resid, d1, d2, d3, photographers, e1, e2, e3);
			if (isTrue2 == true) {
				try {
					// Retrieve reservation details and services associated with the reservation
					List<IT22603418_ReservationDetails> resDetails = ReservationDB.validate(Resid);
					request.setAttribute("resDetails", resDetails);
					List<IT22603418_Services> serDetails = ReservationDB.iT22603418_Services(Resid);
					request.setAttribute("serDetails", serDetails);
					logger.logInfo("Reservation Updated Successfully");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					RequestDispatcher dis = request.getRequestDispatcher("IT22603418/IT22603418_viewReserve.jsp");
					dis.forward(request, response);
			}
		}else {
			logger.logWarning("Reservation not Updated Successfully!!!");
			RequestDispatcher dis2 = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
