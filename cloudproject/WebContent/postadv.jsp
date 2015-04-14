<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>POST </title>
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
    
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">SEARCH</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">LOGOUT</a></li>
      </ul>
    </div>
  </div>
</nav>
	


  

  <div class="jumbotron col-lg-8" style="margin-top: 50px">
  <form class="form-horizontal col-lg-6" style="margin-top: 50px action="postadvaction">
  <fieldset>
    <legend>POST YOUR ADV. HERE</legend>
   
    <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">TITLE</label>
      <div class="col-lg-8">
        <input name="title" type="text" class="form-control" id="inputEmail" placeholder="TITLE">
      </div>
    </div>

      <div class="form-group">
      <label for="inputEmail" class="col-lg-4 control-label">TAG</label>
      <div class="col-lg-8">
        <input name="tag" type="text" class="form-control" id="inputEmail" placeholder="TAG">
      </div>
    </div>


    <div class="form-group">
      <label for="textArea" class="col-lg-4 control-label">DESCRIPTION</label>
      <div class="col-lg-8">
        <textarea name="description" class="form-control" rows="3" id="address" placeholder="DESCRIPTION"></textarea>
      </div>
    </div>
  <div class="form-group">
       <label for="inputEmail" class="col-lg-4 control-label">CATEGORY</label>
       <div class="col-lg-8">
    <select  style="width: 270px ; height: 39px" name="category">
   <option value="TUTOR"> TUTOR</option>
    <option value="PARLAR JOBS"> PARLAR JOBS</option>
     <option value="TIFFIN CENTRE"> TIFFIN CENTRE</option>
      <option value="DATA ENTRY"> DATA ENTRY</option>
      <option value="EVENT ORGANIZATION"> EVENT ORGANIZATION</option>
  </select>
  </div>
  </div>

     
    <div class="form-group">
       <label for="inputEmail" class="col-lg-4 control-label">LOCATION</label>
       <div class="col-lg-8">
    <select  style="width: 270px ; height: 39px" name="location" >
   <option value="indore"> indore</option>
    <option value="bhopal"> bhopal</option>
     <option value="banglore"> banglore</option>
      <option value="hyderabad"> hyderabad</option>
 </select>
</div>
 </div>

    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-4">
        <button type="reset" class="btn btn-default">RESET</button>
        <button type="submit" class="btn btn-primary">POST ADV</button>
      </div>
    </div>
  </fieldset>
</form>


  <div class="col-lg-1" style="margin-top:10px">
    <h4> welcome USER</h4>
</div>

</div>





<div class="jumbotron col-lg-12">
  
  <br><br><br><br><br>
</div>
</body>
</html>