<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>SIGNUP inside</title>
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
      <a class="navbar-brand" href="#">ASKFORIT</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <form class="navbar-form navbar-left" role="search" action="search1">
        <div class="form-group">
          <input name="location" type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">SEARCH</button>
      </form>
      <form class="navbar-form navbar-left" role="logout" action="logout">
			<ul class="nav navbar-nav navbar-right">
				<li><button type="submit" class="btn btn-default">LOGOUT</button></li>
			</ul>
			</form>
    </div>
  </div>
</nav>
	


  

  <div class="jumbotron col-lg-8" style="margin-top: 50px">
  <form class="form-horizontal col-lg-6" style="margin-top: 50px" action="signupaction">
  <fieldset>
    <legend>Signup</legend>
   
    
     <div class="form-group">
      <label for="textArea" class="col-lg-4 control-label">ADDRESS</label>
      <div class="col-lg-8">
        <textarea name="address" class="form-control" rows="3" id="address" placeholder="ADDRESS"></textarea>
      </div>
    </div>
 


    <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">CITY</label>
      <div class="col-lg-8">
        <input name="city" type="text" class="form-control" id="inputEmail" placeholder="CITY">
      </div>
    </div>

    <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">COUNTRY</label>
      <div class="col-lg-8">
        <input name="country" type="text" class="form-control" id="inputEmail" placeholder="COUNTRY">
      </div>
    </div>

     <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">CONTACT NUMBER1</label>
      <div class="col-lg-8">
        <input name="contact1" type="text" class="form-control" id="inputEmail" placeholder="CONTACT NUMBER 1">
      </div>
    </div>

    <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">CONTACT NUMBER2 </label>
      <div class="col-lg-8">
        <input name="contact2" type="text" class="form-control" id="inputEmail" placeholder="CONTACT NUMBER 2">
      </div>
    </div>

    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-4">
        <button type="reset" class="btn btn-default">RESET</button>
        <button type="submit" class="btn btn-primary">NEXT</button>
      </div>
    </div>
  </fieldset>
</form>


  <div class="col-lg-1" style="margin-top:10px">
    <h4> welcome ${it}</h4>
</div>

</div>





<div class="jumbotron col-lg-12">
  
  <br><br><br><br><br>
</div>
</body>
</html>