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

import logUtill.ReserveLogger;

//servlet for quote updation
@WebServlet("/s_quoteUpdateServlet")
public class s_quoteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReserveLogger logger = ReserveLogger.getInstance(); // logger object creation

		try {
			List<s_quote> s_quoteList = new ArrayList<>();

			double totalPrice = 0;
			String qid = request.getParameter("qid"); // get the quote id value as a parameter

			for (int i = 1; i <= 3; i++) { // iterate 3 times through the for loop to get update the all the items which
											// are in same category
				s_quote squote = new s_quote();
				squote.setQuoteId(qid);
				squote.setItemName(request.getParameter("Iname" + i));
				squote.setQuantity(Double.parseDouble(request.getParameter("qty" + i)));
				squote.setUnitPrice(Double.parseDouble(request.getParameter("Uprice" + i)));
				squote.setItemPrice(squote.getQuantity() * squote.getUnitPrice());

				totalPrice = totalPrice + squote.getItemPrice();
				s_quoteList.add(squote);
			}

			boolean isTrue;
			s_supplierDBModel sp = new s_supplierDBModel();
			isTrue = sp.updateQuote(s_quoteList, qid, totalPrice); // access the updateQuote method in supplierDBModel
																	// class

			// isTrue = s_supplierDBModel.updateQuote(s_quoteList,qid,totalPrice);

			if (isTrue == true) {
				logger.logInfo("Quotation Updated Sucessfully");
				RequestDispatcher dis = request.getRequestDispatcher("s_singleQuote.jsp"); // Redirection to the single
																							// quote view
				dis.forward(request, response);
			} else {
				logger.logWarning("Error has occured");
				RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
				dis.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
