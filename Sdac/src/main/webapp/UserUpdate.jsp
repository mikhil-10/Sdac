<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>user</title>
   
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <style>
    body{
        background-color: royalblue;
        background-image: linear-gradient(to bottom, royalblue, white);
    }
    .form{
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
    .main-row{
        margin-top: 10%;
    }
    .card{
        cursor: pointer;
    }
    .card .card-title{
        font-size: 25px;
        font-weight: 500;
        margin: auto;
    }
    .card h2{
        transform: translateY(-50px);
        margin-top: 10px;
        border-radius: 15px;
        z-index: 1; 
    }
    .card .card-body{
        visibility: hidden;
        transform: translateY(-150px);
        height: 0px;
        align-items: center;
        justify-content: center;
    }
    .card:hover .card-body{
        visibility: visible;
        transform: translateY(-50px);
        transition: .5s;
        height: auto;
    }
    
  </style>
</head>
<body>
    <center>
    <form class="form" action="ProductController2" method="post">
   <div class="container">
    <div class="row main-row">
        <div class="col-md-4 mb-5">
            <div class="card p-3" style="width: 18rem;" >
                <div class="card-title">Update Details</div>
                <br> <br>
                <div class="card-body">
                    <h4>Product Name</h4>
                    <input class="form-control"  name="namee" required>
                
                    <h4>Functionality</h4>
                    <input class="form-control" name="function" required>
                
                    <h4>Performance</h4>
                    <input class="form-control" name="perform" required>
                    <h4>Usability</h4>
                    <input class="form-control" name="use" required>
                    <h4>Cost</h4>
                    <input class="form-control" name="cost" required >
                
                    <h4>Value</h4>
                    <input class="form-control" name="value" required >
                    <h4>Environmental Impact</h4>
                    <input class="form-control" name="Effect" required>
                
                    <h4>Customer Feedback</h4>
                    <input class="form-control" name="Feedback" required>
                    <br>
                </div>
          <button type="submit" name="button" value="updatebutton">Update</button>
            </div>
        </div>
        
    </div>
   </div>
</form>
</center>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
