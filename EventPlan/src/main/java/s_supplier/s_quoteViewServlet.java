package s_supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet for quote view
@WebServlet("/s_quoteViewServlet")
public class s_quoteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String qid = request.getParameter("view");
		try {
			// List<s_quote> s_quoteLists = new ArrayList<>();

			List<s_quote> s_quoteLists = s_supplierDBModel.ViewAllQuotes(qid); // access to the view all quotes in
																					// supplierDBModel class
			request.setAttribute("s_quoteLists", s_quoteLists); // store the values to the s_quoteLists to bring them to
																// the jsp page
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dis = request.getRequestDispatcher("s_quoteView.jsp"); // redirection to the s_quoteView page
		dis.forward(request, response);

	}

}
