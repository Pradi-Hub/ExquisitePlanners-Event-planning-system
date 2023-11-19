package s_supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logUtill.ReserveLogger;

@WebServlet("/s_quoteDeleteServlet") // servlet for quote deletion
public class s_quoteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String qid = request.getParameter("paramName"); // get the quote id as a parameter from the quote view page
		ReserveLogger logger = ReserveLogger.getInstance(); // object creation for logger files
		boolean isTrue;
		s_supplierDBModel sp = new s_supplierDBModel(); // access the supplierDBModel class
		isTrue = sp.deleteQuote(qid);

		// isTrue = s_supplierDBModel.deleteQuote(qid);

		if (isTrue == true) {

			logger.logInfo("Quotation Deleted Sucessfully"); // enabled logger info
			RequestDispatcher dispatcher = request.getRequestDispatcher("supplierHome.jsp"); // redirection to supplier
																								// home page
			dispatcher.forward(request, response);
		} else {

			List<s_quote> ViewAllQuotes = s_supplierDBModel.ViewAllQuotes(qid); // if any error occurred it will be in
																				// the same page
			request.setAttribute("ViewAllQuotes", ViewAllQuotes);

			logger.logWarning("Error has occured"); // enabled logger warning for if any error occurred
			RequestDispatcher dispatcher = request.getRequestDispatcher("s_quoteView.jsp");
			dispatcher.forward(request, response);
		}

	}

}
