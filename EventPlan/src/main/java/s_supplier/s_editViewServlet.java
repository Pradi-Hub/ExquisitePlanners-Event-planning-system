package s_supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s_editViewServlet") // Servlet of viewing the edit quotation form
public class s_editViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // do post service start

		String qid1 = request.getParameter("paramName1"); // passing the quote id as a parameter from the view all page
															// to the edit form
		try {
			// List<s_quote> s_quoteLists = new ArrayList<>();

			List<s_quote> viewquote = s_supplierDBModel.viewEditform(qid1); // calling the function viewEdit method in
																			// supplierDBModel class
			request.setAttribute("viewquote", viewquote); // set and store all the values to the relavent parameters
															// from viewquote object and variable
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dis = request.getRequestDispatcher("s_updateQuote.jsp"); // navigate to the update quote form
																					// after successful value selection
		dis.forward(request, response);

	}

}
