package s_supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.PackageInterfaceImplement;
import com.user.DBConnect;
import logUtill.ReserveLogger;
import s_supplier.s_quoteChild;

// servlet class for quote insertion
@WebServlet("/s_quoteInsertServlet")
public class s_quoteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReserveLogger logger = ReserveLogger.getInstance(); // logger object creation
		List<s_quote> s_quoteList = new ArrayList<>();
		String quote_no = QuoteNumberGenerator.generateRandomQuoteNumber(); // assign the random generated value to the
																			// quote id

		double totalPrice = 0; // total item price initially 0

		for (int i = 1; i <= 3; i++) { // iterate 3 times through the for loop to add the items under same quote id
			s_quote squote = new s_quote();
			squote.setItemName(request.getParameter("Iname" + i));
			squote.setQuantity(Double.parseDouble(request.getParameter("qty" + i)));
			squote.setUnitPrice(Double.parseDouble(request.getParameter("Uprice" + i)));
			squote.setItemPrice(squote.getQuantity() * squote.getUnitPrice());

			totalPrice = totalPrice + squote.getItemPrice();
			s_quoteList.add(squote); // add all the assigned values to the s_quote list object
		}

		try {
			boolean isTrue;

			// request.setAttribute("s_quoteList",s_quoteList);
			// isTrue = s_supplierDBModel.insertQuote(name, qty, unit);
			s_supplierDBModel sp = new s_supplierDBModel(); // access the insertquote method in supplierDBModel class
			isTrue = sp.insertQuoteList(s_quoteList, quote_no, totalPrice);

			if (isTrue == true) {

				// Add JavaScript to reset the form after success
				request.setAttribute("successMessage", "Quotation Created Successfully!");
				response.getWriter().println("<script>resetForm();</script>");

				logger.logInfo("Quotation Created Sucessfully"); // logger info enabled
				RequestDispatcher dis = request.getRequestDispatcher("supplierHome.jsp"); // redirection to the home
																							// supplier page
				dis.forward(request, response);

			} else {

				logger.logWarning("Error has occured"); // logger warning enabled
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
		} catch (Exception e) { // catching the exceptions
			e.printStackTrace();
		}

	}

}
