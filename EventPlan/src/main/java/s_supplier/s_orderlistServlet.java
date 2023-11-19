package s_supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s_orderlistServlet")
public class s_orderlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Servlet for viewing the order list
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderId = request.getParameter("Oname"); // Get the orderID from the search bar as a parameter

		try {
			List<s_order> oDetails = s_supplierDBModel.validate(orderId); // calling the validate method in
																			// supplierDBModel class
			request.setAttribute("oDetails", oDetails); // set and store all the values to the odetails object into
														// variable
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dis = request.getRequestDispatcher("orderlist.jsp"); // Redirect to the orderlist page after
																				// calling this servlet.
		dis.forward(request, response);
	}
}
