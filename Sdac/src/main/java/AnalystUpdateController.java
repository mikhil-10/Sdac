

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AnalystUpdateController
 */
public class AnalystUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalystUpdateController() {
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
		  // Create a new product
		 String name = request.getParameter("name");
	        String functionality = request.getParameter("Functionality");
	        String performance = request.getParameter("Performance");
	        String usability = request.getParameter("Usability");
	        String cost = request.getParameter("Cost");
	        String value = request.getParameter("Value");
	        String environmentalEffect = request.getParameter("Impact");

	        Analystpojo analystpojo = new Analystpojo(name, functionality, performance, usability,
	                cost, value, environmentalEffect);

        AnalystDao1 analyst = new AnalystDao1();
        try {
			analyst.update(analystpojo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AnalystSucces.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnalystSucces.jsp");
		dispatcher.forward(request, response);

	}

}
