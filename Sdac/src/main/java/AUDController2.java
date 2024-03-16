

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class AUDController2
 */
public class AUDController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AUDController2() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String usertype = request.getParameter("usertype");
        
        String url = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "";
        
        // SQL query to update data
        String query = "UPDATE users SET type = '"+usertype+"' WHERE fullname ='"+id+"'";
        
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
