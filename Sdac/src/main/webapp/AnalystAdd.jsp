<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<style>
body {
	background-color: royalblue;
	background-image: linear-gradient(to bottom, royalblue, white);
}

.form {
	display: flex;
	flex-direction: column;
	gap: 10px;
	max-width: 350px;
	background-color: #fff;
	padding: 20px;
	border-radius: 20px;
	position: relative;
	margin-top: 75px;
}

.main-row {
	margin-top: 10%;
}

.card {
	cursor: pointer;
}

.card .card-title {
	font-size: 25px;
	font-weight: 500;
	margin: auto;
}

.card h2 {
	transform: translateY(-50px);
	margin-top: 10px;
	border-radius: 15px;
	z-index: 1;
}

.card .card-body {
	visibility: hidden;
	transform: translateY(-150px);
	height: 0px;
	align-items: center;
	justify-content: center;
}

.card:hover .card-body {
	visibility: visible;
	transform: translateY(-50px);
	transition: .5s;
	height: auto;
}

.form-control {
	border-width: 3px;
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
</style>
</head>

<body>
	<nav>
		<input type="checkbox" id="check"> <label for="check"
			class="checkbtn"> <i class="fas fa-bars"></i>
		</label> <label class="logo">Exedy</label>
		<ul>
			<li><a href="Home.jsp">Home</a></li>
			<li><a href="Viewer.jsp">Viewer</a></li>
			<li><a class="active" href="#">Admin</a></li>
		</ul>
	</nav>

	<center>
		<form class="form" action="AnalystAddController" method="post">
			<div class="container">
				<div class="row main-row">
					<div class="col-md-4 mb-5">
						<div class="card p-3" style="width: 18rem;">
							<div class="card-title">Add Details</div>
							<br> <br>
							<div class="card-body">
								<h4>Product Name</h4>
								<input class="form-control" name="name" required>

								<h4>Functionality</h4>
								<input class="form-control" name="Functionality" required>

								<h4>Performance</h4>
								<input class="form-control" name="Performance" required>
								<h4>Usability</h4>
								<input class="form-control" name="Usability" required>
								<h4>Cost</h4>
								<input class="form-control" name="Cost" required>

								<h4>Value</h4>
								<input class="form-control" name="Value" required>
								<h4>Environmental Impact</h4>
								<input class="form-control" name="Impact" required>
								<br>
							</div>
							<button class="button" type="submit">save</button>
						</div>
					</div>

				</div>
			</div>
		</form>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>

</html>