<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error Page</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <style>
    body {
      background-color: #f5f5f5;
    }
    .container {
      max-width: 400px;
      margin-top: 100px;
      text-align: center;
    }
    .error-circle {
      width: 70px;
      height: 70px;
      border-radius: 50%;
      border: 3px solid #dc3545;
      display: inline-flex;
      justify-content: center;
      align-items: center;
      margin-bottom: 30px;
      animation: error-circle-animation 0.5s ease-in-out;
    }
    .error-circle i {
      color: #dc3545;
      font-size: 40px;
    }
    .message {
      font-size: 20px;
      font-weight: bold;
      margin-bottom: 30px;
      color: #dc3545;
    }
    .btn-back {
      text-decoration: none;
    }
    
    @keyframes error-circle-animation {
      0% {
        transform: scale(0);
        opacity: 0;
      }
      100% {
        transform: scale(1);
        opacity: 1;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="error-circle">
      <i class="fas fa-times"></i>
    </div>
    <div class="message">
      Error: The update failed.
    </div>
    <a href="AnalystMain.jsp" class="btn btn-primary btn-back">Go Back</a>
  </div>

  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/your-font-awesome-kit.js" crossorigin="anonymous"></script>
</body>
</html>
