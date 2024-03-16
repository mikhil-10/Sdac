

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Servlet implementation class ReportDao
 */
public class ReportDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDao() {
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
		
		
		 String JDBC_URL = "jdbc:mysql://localhost:3306/product";
			String USERNAME = "root";
			String PASSWORD = "";
			try {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			Connection conn = null;
				conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		// Creating a PdfWriter       
		      String dest = "C:\\PDF\\MikhilProject.pdf";       
		      PdfWriter writer = new PdfWriter(dest);           
		      
		   // Creating a PdfDocument  
		      PdfDocument pdfDoc = new PdfDocument(writer);           
		      pdfDoc.addNewPage(); 
		      // Creating a Document        
		      Document document = new Document(pdfDoc);          
		      
		      String sql="select * from products";
		      PreparedStatement ps=conn.prepareStatement(sql);
		      ResultSet rs=ps.executeQuery(sql);
		      while(rs.next()) {
		    	 Paragraph para=new Paragraph( rs.getString("name")+"  "+rs.getString("functionality")+"   "+rs.getString("performance")+"   "+rs.getString("usability")+"  "+rs.getString("cost")+"  "+rs.getString("values"));
		    	 document.add(para);
		      }
		      
		      // Closing the document       
		      document.close();             
		      System.out.println("Paragraph added");
		      
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   
	}
	}

}
