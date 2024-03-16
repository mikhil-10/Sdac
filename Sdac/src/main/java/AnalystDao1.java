import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AnalystDao1 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/product";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public void insert(Analystpojo analyst) {
        try {
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Prepare the SQL statement
            String sql = "INSERT INTO products (name, functionality, performance, usability, cost, value, environmentalEffect) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Set the parameter values
            stmt.setString(1, analyst.getName());
            stmt.setString(2, analyst.getFunctionality());
            stmt.setString(3, analyst.getPerformance());
            stmt.setString(4, analyst.getUsability());
            stmt.setString(5, analyst.getCost());
            stmt.setString(6, analyst.getValue());
            stmt.setString(7, analyst.getEnvironmentalEffect());

            // Execute the statement
            stmt.executeUpdate();

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any errors that occur during the insertion
        }
    }

    public void update(Analystpojo analyst) throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        String query = "UPDATE products SET functionality = ?, performance = ?, usability = ?, cost = ?, value = ?, environmentalEffect = ? WHERE name=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(7, analyst.getName());
            statement.setString(1, analyst.getFunctionality());
            statement.setString(2, analyst.getPerformance());
            statement.setString(3, analyst.getUsability());
            statement.setString(4, analyst.getCost());
            statement.setString(5, analyst.getValue());
            statement.setString(6, analyst.getEnvironmentalEffect());
			/* statement.setInt(9, product.getId()); */

            statement.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
		}
    }

	public static void delete(Analystpojo analyst) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		 String query = "DELETE FROM products WHERE name = ?";
		    try (PreparedStatement statement = conn.prepareStatement(query)) {
		        statement.setString(1, analyst.getName());
		        statement.executeUpdate();
		    }
	}
	
	
	public void report(Analystpojo analyst) throws SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		Connection conn = null;
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	// Creating a PdfWriter       
			try {
	      String dest = "C:\\PDF\\Analyst.pdf";       
	      PdfWriter writer = new PdfWriter(dest);           
	      
	   // Creating a PdfDocument  
	      PdfDocument pdfDoc = new PdfDocument(writer);           
	      pdfDoc.addNewPage(); 
	      // Creating a Document        
	      Document document = new Document(pdfDoc);          
	      
	      String sql="select * from products ";
	      PreparedStatement ps=conn.prepareStatement(sql);
	      ResultSet rs=ps.executeQuery(sql);
	      while(rs.next()) {
	    	 /*Paragraph para=new Paragraph( rs.getString("name")+"  "+rs.getString("functionality")+"   "+rs.getString("performance")+"   "+rs.getString("usability")+" "+rs.getString("cost")+"  "+rs.getString("value")+"  "+rs.getString("environmentalEffect"));
	    	*/ float [] pointColumnWidths = {300F, 300F,300F,300F, 300F,300F,300F}; 
	    	 Table table = new Table(pointColumnWidths);
	    	 
	    	 Cell cell1 = new Cell();     
	    	 cell1.add("Name");
	    	 cell1.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell1);
	    	 
	    	 Cell cell2 = new Cell();     
	    	 cell2.add("Funtionality");
	    	 cell2.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell2);

	    	 Cell cell3 = new Cell();     
	    	 cell3.add("Performance");
	    	 cell3.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell3);
	    	 
	    	 Cell cell4 = new Cell();     
	    	 cell4.add(("Cost"));
	    	 cell4.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell4);
	    	 
	    	 Cell cell5 = new Cell();     
	    	 cell5.add(("Value"));
	    	 cell5.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell5);
	    	 
	    	 Cell cell6 = new Cell();     
	    	 cell6.add(("Usability"));
	    	 cell6.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell6);
	    	 
	    	 Cell cell7 = new Cell();     
	    	 cell7.add(("EnvironmentalEffect"));
	    	 cell7.setBackgroundColor(Color.LIGHT_GRAY);
	    	 table.addCell(cell7);
	    	 
	    	 Cell cell8 = new Cell();     
	    	 cell8.add(rs.getString("name"));
	    	 table.addCell(cell8);
	    	 
	    	 Cell cell9 = new Cell();     
	    	 cell9.add(rs.getString("functionality"));
	    	 table.addCell(cell9);
	    	 
	    	 Cell cell10 = new Cell();     
	    	 cell10.add(rs.getString("performance"));
	    	 table.addCell(cell10);
	    	 
	    	 Cell cell11 = new Cell();     
	    	 cell11.add(rs.getString("cost"));
	    	 table.addCell(cell11);
	    	 
	    	 Cell cell12 = new Cell();     
	    	 cell12.add(rs.getString("value"));
	    	 table.addCell(cell12);
	    	 
	    	 Cell cell13= new Cell();     
	    	 cell13.add(rs.getString("usability"));
	    	 table.addCell(cell13);
	    	 
	    	 Cell cell14 = new Cell();     
	    	 cell14.add(rs.getString("environmentalEffect"));
	    	 table.addCell(cell14);
	    	 
	    	 
	    	 document.add(table);
	    	 
	    	 
	      }
	      
	      // Closing the document       
	      document.close();             
	      System.out.println("Paragraph added");
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	
	}
