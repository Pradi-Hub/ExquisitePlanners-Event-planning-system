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
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;
import com.IT22603418.IT22603418_models.IT22603418_ReservationDBUtil;

@WebServlet("/deleteReserveServlet")
public class IT22603418_deleteReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	
		
		boolean isTrue;

		IT22603418_Reservation ReservationDB = new IT22603418_ReservationDBUtil();

		int Resid = ReservationDB.getResid(email);
		
		isTrue = ReservationDB.deleteReservation(Resid);
		
		if (isTrue == true) {

			logger.logInfo("Reservation Deleted Successfully");
			RequestDispatcher dis = request.getRequestDispatcher("Home_page_IT22603418.jsp");
			dis.forward(request, response);
		}else {
			logger.logWarning("Reservation not deleted Successfully!!!");
			RequestDispatcher dis2 = request.getRequestDispatcher("IT22603418/IT22603418_unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
}
