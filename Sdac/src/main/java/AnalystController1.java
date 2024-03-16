
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
/**
 * Servlet implementation class AnalystController1
 */
public class AnalystController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalystController1() {
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
		String button = request.getParameter("btn");
		
		
		  if(button.equals("addbutton"))
		  { 

				
			  RequestDispatcher dispatcher = request.getRequestDispatcher("AnalystAdd.jsp");
			  dispatcher.forward(request, response);
			  
		  }else
		  if(button.equals("updatebutton"))
		  { 
			RequestDispatcher dispatcher= request.getRequestDispatcher("AnalystUpdate.jsp");
			dispatcher.forward(request, response);
		  }
		  else
		  if(button.equals("deletebutton")) 
		  { 
			  String name=request.getParameter("id");
				String JDBC_URL = "jdbc:mysql://localhost:3306/product";
				String USERNAME = "root";
				String PASSWORD = "";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String query = "delete from products where name = '"+ name+"'";
				try (Statement statement = conn.createStatement()) {
					statement.execute(query);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Analyst.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        RequestDispatcher dispatcher = request.getRequestDispatcher("Analyst.jsp");
				  dispatcher.forward(request, response);

		  }
		  else if(button.equals("report")){
			  RequestDispatcher dispatcher= request.getRequestDispatcher("Generator.jsp");
				dispatcher.forward(request, response);
		  }
		  

}}
