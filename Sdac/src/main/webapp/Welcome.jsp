<html>
  <head>
    <title>Home</title>
    <style>
*{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  
}
.banner{
  width: 100%;
  height: 100vh;
  background-image: linear-gradient(rgba(0,0,0,0.75),rgba(0,0,0,0.75)),url(https://png.pngtree.com/thumb_back/fw800/background/20190222/ourmid/pngtree-gradient-ppt-background-image-windppt-backgroundbackgroundppt-template-image_54617.jpg);
  background-size: cover;
  background-position: center;

}
.logo{
    margin-left: 18px;
  width: 120px;
  cursor: pointer;
}
.content{
  width: 100%;
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  text-align: center;
  color: darkgrey;

}
.content h1{
  font-size: 70px;
  margin-top: 80px;
}

button{
  width: 200px;
  padding: 15px 0;
  text-align:center ;
  margin: 20px 10px;
  border-radius: 25px;
  font-weight: bold;
  border: 2px solid #009688;
  background: transparent;
  color: white;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

span{
  background: #009688;
  height: 100%;
  width: 0;
  border-radius: 25px;
  position: absolute;
  left: 0;
  bottom: 0;
  z-index: -1;
  transition: 0.5s;
}
button:hover span{
  width: 100%;
}
button:hover{
  border: none;
}
h6{
color:white;
padding-top:650px;
padding-left:45%;
}
    </style>
  </head>
  <body>
  <form method="post" action="Home.jsp">
    <div class="banner">
      <img src="data:image/png;base64,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" class="logo">
     
      <div class="content">
        <h1>Welcome to Exedy </h1>
        
        <div>
         
          <button type="submit"><span></span> Start</button>
        </div>
      </div>
      <h6>  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;Made by <br>
      <br> Mikhil, Raj, Sourav, Shreya, Nasruddin</h6>
    </div>
     
    </form>
   
  </body>
</html>