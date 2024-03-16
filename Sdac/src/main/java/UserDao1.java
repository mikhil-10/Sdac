import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao1 {
    private static Connection connection;

    public UserDao1(Connection connection) {
        this.connection = connection;
    }

    public static void create(Product product) throws SQLException {
        String query = "INSERT INTO products (name, functionality, performance, usability, cost, value, environmental_effect, customer_feedback) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getFunctionality());
            statement.setString(3, product.getPerformance());
            statement.setString(4, product.getUsability());
            statement.setString(5, product.getCost());
            statement.setString(6, product.getValue());
            statement.setString(7, product.getEnvironmentalEffect());
            statement.setString(8, product.getCustomerFeedback());

            statement.executeUpdate();
        }
    }

    public Product getById(int id) throws SQLException {
        String query = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToProduct(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Product product = null;
				try {
					product = mapResultSetToProduct(resultSet);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                products.add(product);
            }
        }
        return products;
    }

    private static Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String functionality = resultSet.getString("functionality");
        String performance = resultSet.getString("performance");
        String usability = resultSet.getString("usability");
        String cost = resultSet.getString("cost");
        String value = resultSet.getString("value");
        String environmentalEffect = resultSet.getString("environmental_effect");
        String customerFeedback = resultSet.getString("customer_feedback");

        return new Product(name, functionality, performance, usability, cost, value,
                           environmentalEffect, customerFeedback);
    }

	public boolean deleteProduct(String productName) {
		
		return false;
		
	}
}
