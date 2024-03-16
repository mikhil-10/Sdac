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

public class ProductDAO {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/product";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public static void insertProduct(Product product) {
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
			String sql = "INSERT INTO reviews (name, functionality, performance, usability, cost, value, environmental_effect, customer_feedback) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Set the parameter values
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getFunctionality());
			stmt.setString(3, product.getPerformance());
			stmt.setString(4, product.getUsability());
			stmt.setString(5, product.getCost());
			stmt.setString(6, product.getValue());
			stmt.setString(7, product.getEnvironmentalEffect());
			stmt.setString(8, product.getCustomerFeedback());

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

	public void updateProduct(Product product) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		String query = "UPDATE reviews SET functionality = ?, performance = ?, usability = ?, cost = ?, value = ?, environmental_effect = ?, customer_feedback = ? WHERE name=?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(8, product.getName());
			statement.setString(1, product.getFunctionality());
			statement.setString(2, product.getPerformance());
			statement.setString(3, product.getUsability());
			statement.setString(4, product.getCost());
			statement.setString(5, product.getValue());
			statement.setString(6, product.getEnvironmentalEffect());
			statement.setString(7, product.getCustomerFeedback());
			/* statement.setInt(9, product.getId()); */

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public Product getById(int id) throws SQLException { Connection conn =
	 * DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); String query =
	 * "SELECT * FROM products WHERE id = ?"; try (PreparedStatement statement =
	 * conn.prepareStatement(query)) { statement.setInt(1, id); try (ResultSet
	 * resultSet = statement.executeQuery()) { if (resultSet.next()) { return
	 * mapResultSetToProduct(resultSet); } } } return null; }
	 */

	public static boolean deleteProduct(String productName) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			String query = "DELETE FROM products WHERE productName = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, productName);
			int row = statement.executeUpdate();
			return false;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public void report(Product product) {
		// TODO Auto-generated method stub
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
		// Creating a PdfWriter
		try {
			String dest = "C:\\PDF\\USERS.pdf";
			PdfWriter writer = new PdfWriter(dest);

			// Creating a PdfDocument
			PdfDocument pdfDoc = new PdfDocument(writer);
			pdfDoc.addNewPage();
			// Creating a Document
			Document document = new Document(pdfDoc);

			String sql = "SELECT * from reviews ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				/*Paragraph para = new Paragraph(rs.getString("name") + "      " + rs.getString("functionality")+ "      " + rs.getString("performance") + "  " + rs.getString("usability") +"  "+ rs.getString("cost") + "   " + rs.getString("value") + "   "+ rs.getString("environmental_effect") + "  " + rs.getString("customer_feedback"));
				*/
				float [] pointColumnWidths = {300F, 300F,300F,300F, 300F,300F,300F,300F}; 
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
		    	 cell7.add(("Enviornmental Effect"));
		    	 cell7.setBackgroundColor(Color.LIGHT_GRAY);
		    	 table.addCell(cell7);
		    	 
		    	 Cell cell8= new Cell();     
		    	 cell8.add(("Feedback"));
		    	 cell8.setBackgroundColor(Color.LIGHT_GRAY);
		    	 table.addCell(cell8);
		    	 
		    	 Cell cell9 = new Cell();     
		    	 cell9.add(rs.getString("name"));
		    	 table.addCell(cell9);
		    	 
		    	 Cell cell10= new Cell();     
		    	 cell10.add(rs.getString("functionality"));
		    	 table.addCell(cell10);
		    	 
		    	 Cell cell11 = new Cell();     
		    	 cell11.add(rs.getString("performance"));
		    	 table.addCell(cell11);
		    	 
		    	 Cell cell12 = new Cell();     
		    	 cell12.add(rs.getString("cost"));
		    	 table.addCell(cell12);
		    	 
		    	 Cell cell13 = new Cell();     
		    	 cell13.add(rs.getString("value"));
		    	 table.addCell(cell13);
		    	 
		    	 Cell cell14= new Cell();     
		    	 cell14.add(rs.getString("usability"));
		    	 table.addCell(cell14);
		    	 
		    	 Cell cell15 = new Cell();     
		    	 cell15.add(rs.getString("environmental_effect"));
		    	 table.addCell(cell15);
		    	 
		    	 Cell cell16 = new Cell();     
		    	 cell16.add(rs.getString("customer_feedback"));
		    	 table.addCell(cell16);
				document.add(table);
			}

			// Closing the document
			document.close();
			System.out.println("Report generated");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
