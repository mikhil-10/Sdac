

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class UserReportController
 */
public class UserReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Create a new product
        String name = request.getParameter("name");
        String functionality = request.getParameter("functionality");
        String performance = request.getParameter("performance");
        String usability = request.getParameter("usability");
        String cost = request.getParameter("cost");
        String value = request.getParameter("value");
        String environmentalEffect = request.getParameter("environmentalEffect");
        String customerFeedback = request.getParameter("customerFeedback");

        Product product = new Product(name, functionality, performance, usability,
                cost, value, environmentalEffect, customerFeedback);

        ProductDAO productDAO = new ProductDAO();
		productDAO.report(product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserMain.jsp");
		dispatcher.forward(request, response);
    }

}
