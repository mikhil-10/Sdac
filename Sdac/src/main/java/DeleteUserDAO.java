import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/product";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE username = ?";

    public boolean deleteUser(String username) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
            statement.setString(1, username);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
