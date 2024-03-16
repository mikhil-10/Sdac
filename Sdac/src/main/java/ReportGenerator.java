import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;  

public class ReportGenerator { 
   public static void main(String args[]) throws Exception {
	   
	   String JDBC_URL = "jdbc:mysql://localhost:3306/product";
		String USERNAME = "root";
		String PASSWORD = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		
	   
	   
	// Creating a PdfWriter       
	      String dest = "C:\\Mikhil\\Product.pdf";       
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
	    	 Paragraph para=new Paragraph( rs.getString("name")+"  "+rs.getString("functionality")+"   "+rs.getString("performance")+"   "+rs.getString("usability"));
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