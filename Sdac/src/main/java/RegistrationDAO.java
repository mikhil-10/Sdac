import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/product";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USER_SQL = "INSERT INTO users (fullname, username, password, email) VALUES (?, ?, ?, ?)";

    public RegistrationDAO() {
    }

    protected Connection getConnection() {	
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean registerUser(RegistrationPOJO registration) throws SQLException {
        boolean rowInserted = false;
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(1, registration.getFullName());
            statement.setString(2, registration.getUsername());
            statement.setString(3, registration.getPassword());
            statement.setString(4, registration.getEmail());

            rowInserted = statement.executeUpdate() >= 1;
            return rowInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return rowInserted;
        }
        
    }
}
