

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UserUpdate
 */
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
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
		// TODO Auto-generated method stub
		String product = request.getParameter("Product");
        String function = request.getParameter("Functionality");
        String performance = request.getParameter("Performance");
        String usability = request.getParameter("Usability");
        String Cost = request.getParameter("cost");
        String Value = request.getParameter("value");
        String impact = request.getParameter("Impact");
        String feedback = request.getParameter("Feedback");
        
        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "";
        
        // SQL query to update data
        String query = "UPDATE reviews SET functionality='"+function+"',performance='"+performance+"', Usability='"+usability+"', cost='"+Cost+"', value='"+Value+"', environmental_effect='"+impact+"',customer_feedback='"+feedback+"' where name='"+product+"'";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            
            // Execute the update query
            int rowsAffected = stmt.executeUpdate(query);
            
            // Check the number of rows affected
            System.out.println("Rows affected: " + rowsAffected);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
	}

}
