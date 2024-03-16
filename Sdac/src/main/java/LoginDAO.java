import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;

public class LoginDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/product"; // Replace with your database URL
    private String username = "root"; // Replace with your database username
    private String password = ""; // Replace with your database password

    public String validate(User user) {
        String sql = "SELECT type FROM users WHERE username = ? AND password = ?";
        
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            String type = rs.getString("type");
            if(type.equals("user")) {
            	return "user";
            }else {
            	return "analyst";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
