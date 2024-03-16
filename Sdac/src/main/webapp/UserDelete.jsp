<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<html>
<head>
<title> Product Details</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1>Product Details</h1>

	<table>
		<tr>
		<th>ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Functionality</th>
			<th>Performance</th>
			<th>Usability</th>
			<th>Cost</th>
			<th>Value</th>
			<th>Environmental Impact</th>
			<th>Customer Feedback</th>
			<th>Delete</th>
		</tr>
		<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "123456");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products1");

			while (resultSet.next()) {
String id = resultSet.getString("id");
				String productname = resultSet.getString("productname");
				String productdescription = resultSet.getString("productdescription");
				String functionality = resultSet.getString("functionality");
				String performance = resultSet.getString("performance");
				String usability = resultSet.getString("usability");
				String cost = resultSet.getString("cost");
				String value = resultSet.getString("value");
				String environmental_impact = resultSet.getString("environmental_impact");
				String customer_feedback = resultSet.getString("customer_feedback");
		%>
		<tr>
		<td><%=id%></td>
			<td><%=productname%></td>
			<td><%=productdescription%></td>
			<td><%=functionality%></td>
			<td><%=performance%></td>
			<td><%=usability%></td>
			<td><%=cost%>
			<td><%=value%>
			<td><%=environmental_impact%></td>
			<td><%=customer_feedback%></td>
			<td>
				<form action="DeleteServlet" method="post"><input type="hidden" name="productname" value="<%=productname%>">
				<button type="submit">Delete</button>
				</form>
			</td>
		</tr>
		<%
		}
		resultSet.close();
		statement.close();
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>