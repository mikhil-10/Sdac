<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<style>
/* Add your custom styles here */
/* ... */
* {
	padding: 0;
	margin: 0;
	text-decoration: none;
	list-style: none;
	box-sizing: border-box;
}

body {
	font-family: montserrat;
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

section {
	background: linear-gradient(to bottom, royalblue, white);
	background-repeat: no-repeat;
	background-size: cover;
	height: calc(100vh - 80px);
}

.alert {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
}

.alert-success {
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
}

.alert-danger {
	color: #721c24;
	background-color: #f8d7da;
	border-color: #f5c6cb;
}

* {
	box-sizing: border-box;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f1f1f1;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 16px;
}


.button {
	background-color: #0082e6;
	color: #fff;
	padding: 14px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
	font-size: 16px;
}

.button:hover {
	background-color: #3aa1ef;
}

.form-footer {
	margin-top: 20px;
	text-align: center;
	color: #777;
}

.form-footer a {
	color: #3aa1ef;
	text-decoration: none;
}

.form-footer a:hover {
	text-decoration: underline;
}

.form-toggle {
	text-align: center;
	margin-top: 20px;
}

.form-toggle input[type="checkbox"] {
	display: none;
}

.form-toggle label {
	color: #777;
	cursor: pointer;
}

.form-toggle label:before {
	content: "\f2f6";
	font-family: "Font Awesome 5 Free";
	display: inline-block;
	margin-right: 5px;
}

.form-toggle input[type="checkbox"]:checked+label:before {
	content: "\f2f5";
}

@media screen and (max-width: 480px) {
	.container {
		width: 90%;
	}
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars"></i>
		</label> <label class="logo">EXEDY</label>
		<ul>
			<li><a class="active" href="#">Home</a></li>
			<li><a href="Viewer.jsp">Viewer</a></li>
			<li><a href="AdminLogin.jsp">Admin</a></li>
		</ul>
	</nav>
	<section></section>
	<div class="container">
		<h2>Register</h2>
		<form action="Controller" method="POST">
			<input type="text" name="fullname" placeholder="Fullname" required>
			<input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"required> 
			<input type="text" name="email" placeholder="Email" required>
			<button class="button" type="submit">Register</button>
			<div class="form-footer">
				Already have an account? <a href="Home.jsp">Login</a>
			</div>
		</form>
		<div class="form-toggle">
			<input type="checkbox" id="toggle"> <label for="toggle">Show
				Password</label>
		</div>
	</div>

	<script>
		// Add your custom JavaScript here
		// ...
		const toggle = document.getElementById("toggle");
		const password = document.querySelectorAll('input[type="password"]');

		toggle.addEventListener("change", function() {
			password.forEach(function(el) {
				el.type = toggle.checked ? "text" : "password";
			});
		});
	</script>
</body>
</html>


