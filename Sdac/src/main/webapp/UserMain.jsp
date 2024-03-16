<!DOCTYPE html>
<html lang="en">
<%@ page import="java.sql.*"%>

<!-- divinectorweb.com -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
  body{
     background:rgb(117, 142, 216);
        
  }
.tab-content {
	padding: 20px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}





/* Responsive Styles */
@media ( max-width : 600px) {
	.product-card {
		width: 100%;
	}
}

.product-card h3 {
	margin-top: 15px;
}


nav {
	background: #0082e6;
	height: 80px;
	width: 100%;
}

label.logo {
	color: white;
	font-size: 35px;
	line-height: 80px;
	padding: 0 100px;
	font-weight: bold;
}

nav ul {
	float: right;
	margin-right: 20px;
}

nav ul li {
	display: inline-block;
	line-height: 80px;
	margin: 0 5px;
}

nav ul li a {
	color: white;
	font-size: 17px;
	padding: 7px 13px;
	border-radius: 3px;
	text-transform: uppercase;
}

a.active, a:hover {
	background: #1b9bff;
	transition: .5s;
}

.checkbtn {
	font-size: 30px;
	color: white;
	float: right;
	line-height: 80px;
	margin-right: 40px;
	cursor: pointer;
	display: none;
}

#check {
	display: none;
}

@media ( max-width : 952px) {
	label.logo {
		font-size: 30px;
		padding-left: 50px;
	}
	nav ul li a {
		font-size: 16px;
	}
}

@media ( max-width : 858px) {
	.checkbtn {
		display: block;
	}
	ul {
		position: fixed;
		width: 100%;
		height: 100vh;
		background: #2c3e50;
		top: 80px;
		left: -100%;
		text-align: center;
		transition: all .5s;
	}
	nav ul li {
		display: block;
		margin: 50px 0;
		line-height: 30px;
	}
	nav ul li a {
		font-size: 20px;
	}
	a:hover, a.active {
		background: none;
		color: #0082e6;
	}
	#check:checked ~ ul {
		left: 0;
	}
}
/* section{
 background:rgb(117, 142, 216);
	background-size: cover;
	height: calc(100vh - 80px);
} */

	
.add-button {
	position: absolute;
	margin-top: 100px;
	top: 20px;
	right: 20px;
	background-color: white;
	border: #0082e6;
	border-bottom: 1px solid #ddd;
	border-radius: 5px;
	width: 95px;
	height: 35px;
	text-align: center;
	justify-content: center;
	font-size: 18px;
	

}

</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars"></i>
		</label> <label class="logo">Exedy</label>
		<ul>
			<li><a  class="active" href="Home.jsp">Home</a></li>
			<li><a  href="Viewer.jsp" >Viewer</a></li>
			<li><a href="AdminLogin.jsp">Admin</a></li>
		</ul>
	</nav>
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#userDetails">User</a></li>
			
		</ul>
		<section>
		<div class="tab-content">
			<div id="userDetails" class="tab-pane fade show active">
				<!-- User Details Content -->
				<h3>User </h3>
				<!-- Add your user details content here -->
				<table>
					<tr>
						<th>Product Name</th>
						<th>Functionality</th>
						<th>Performance</th>
						<th>Usability</th>
						<th>Cost</th>
						<th>Value</th>
						<th>Enviornmental Impact</th>
						<th>Customer Feedback</th>
						<th>Action</th>
						<th>Action</th>
						<th>Action</th>
						<th>Action</th>
					</tr>
					<%
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "");
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery("SELECT * FROM reviews");

						while (resultSet.next()) {
							String name = resultSet.getString("name");
							String functionality = resultSet.getString("functionality");
							String performance = resultSet.getString("performance");
							String usability = resultSet.getString("usability");
							String cost = resultSet.getString("cost");
							String value = resultSet.getString("value");
							String environmentalEffect = resultSet.getString("environmental_effect");
							String customer = resultSet.getString("customer_feedback");
					%>
					<tr><form action="UserUpdate1" method="post">
						<td><input type="text" name='name' value='<%=name%>' readonly></td>
						<td><%=functionality%></td>
						<td><%=performance%></td>
						<td><%=usability%></td>
						<td><%=cost%></td>
						<td><%=value%></td>
						<td><%=environmentalEffect%></td>
						<td><%=customer%></td>
						<td><button type="submit" name="button"  value="addbutton">Add</button></td>
						<td><button type="submit" name="button" value="updatebutton">Update</button></td>
           				 <td><button type="submit" name="button" value="deletebutton">Delete</button></td>
						<td><button type="submit" name="button" value="reportbutton">Report</button></td>
						
						
						</form>
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
			</div>
			
		
					
			 <script>
        $(document).ready(function() {
          $('.switcher').on('click', function() {
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
          });
        });
      </script>
			<script>
				$(document).ready(function() {
					$(".nav-link").click(function() {
						$(this).tab('show');
					});
				});
			</script>
</body>
</html>