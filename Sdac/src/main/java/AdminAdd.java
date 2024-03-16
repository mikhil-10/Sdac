

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminAdd
 */
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdd() {
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
	        analyst.insert(analystpojo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AnalystSuccess.jsp");
			dispatcher.forward(request, response);
	}

}
