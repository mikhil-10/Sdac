

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ProductController2
 */
public class ProductController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController2() {
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
        String name = request.getParameter("namee");
        String functionality = request.getParameter("function");
        String performance = request.getParameter("perform");
        String usability = request.getParameter("use");
        String cost = request.getParameter("cost");
        String value = request.getParameter("value");
        String environmentalEffect = request.getParameter("Effect");
        String customerFeedback = request.getParameter("Feedback");

        Product product = new Product(name, functionality, performance, usability,
                cost, value, environmentalEffect, customerFeedback);

        ProductDAO productDAO = new ProductDAO();
		try {
			productDAO.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
