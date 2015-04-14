<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>HOME PAGE outside</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">ASKFORIT.COM</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <form class="navbar-form navbar-left" role="search" action="search1">
        <div class="form-group">
          <input name="location" type="text" class="form-control" placeholder="Location" required>
        </div>
        <button type="submit" class="btn btn-default">Search</span></button>
      </form>
     
     
      <form class="navbar-form navbar-left" role="search" action="login">
        <div class="form-group">
          <input name="username" type="email" class="form-control" placeholder="email-id" required>
        </div>
        <div class="form-group">
          <input name="password" type="password" class="form-control" placeholder="password" required>
        </div>
        <button type="submit" class="btn btn-default">login</button>
      </form>
      
      	<ul class="nav navbar-nav">
        <li class="active"><a href="#">ABOUT-US <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#">CONTACT-US<span class="sr-only">(current)</span></a></li>
       
      </ul>






     
    </div>
  </div>
</nav>
	<div class="jumbotron col-lg-8" style="margin-top: 50px">
  <h1>ask for it</h1>
  <h3>description and image</h3>
  <br><br><br><br><br><br><br><br><br>
</div>



<form class="form-horizontal col-lg-4" style="margin-top: 50px" action="loginaction" method="get">
  <fieldset>
    <legend>Signup</legend>
    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">FIRST NAME</label>
      <div class="col-lg-10">
        <input name="firstname" type="text" class="form-control" id="inputEmail" placeholder="FIRST NAME" required>
      </div>
    </div>

     <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">LAST NAME</label>
      <div class="col-lg-10">
        <input name="lastname" type="text" class="form-control" id="inputEmail" placeholder="LAST NAME" required>
      </div>
    </div>


    <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">EMAIL</label>
      <div class="col-lg-10">
        <input name="email" type="email" class="form-control" id="inputEmail" placeholder="EMAIL" required>
      </div>
    </div>

     <div class="form-group">
      <label for="inputEmail" class="col-lg-2 control-label">PASSWORD</label>
      <div class="col-lg-10">
        <input name="password" type="password" class="form-control" id="inputEmail" placeholder="PASSWORD" required>
      </div>
    </div>

     
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="reset" class="btn btn-default">RESET</button>
        <button type="submit" class="btn btn-primary">NEXT</button>
      </div>
    </div>
  </fieldset>
</form>

<div class="jumbotron col-lg-12">
  
  <br><br><br><br><br>
</div>
</body>
</html>