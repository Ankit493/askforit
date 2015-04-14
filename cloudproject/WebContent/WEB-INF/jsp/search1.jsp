<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">


<script>
function showAdv(str)
{
var xmlhttp;    
if (str=="")
  {
  document.getElementById("aj").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("aj").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","ajaxcall?q="+str,true);
xmlhttp.send();
}
</script>



<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body>


	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">ASKFORIT</a>

			<form class="navbar-form navbar-left" role="postAd"
				action="postadv.jsp">
				<!-- <div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>-->
				<button type="submit" class="btn btn-default">Post Ad</button>
			</form>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<form class="navbar-form navbar-left" role="search" action="search1">
				<div class="form-group">
					<input name="location" type="text" class="form-control" placeholder="Search" >
				</div>
				<button type="submit" class="btn btn-default">SEARCH</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="LogoutClass">LOGOUT</a></li>
			</ul>
		</div>
	</div>
	</nav>

 
    <div class="form-group">
       <label for="inputEmail" class="col-lg-4 control-label"><h3>CATEGORY WISE SEARCH</h3></label>
       <div class="col-lg-8">
    <select  style="width: 270px ; height: 39px" name="category"  onchange="showAdv(this.value)">
  	<option value="select category"> select category</option>
   <option value="TUTOR"> TUTOR</option>
    <option value="PARLOR JOBS"> PARLAR JOBS</option>
     <option value="TIFFIN CENTRE"> TIFFIN CENTRE</option>
      <option value="DATA ENTRY"> DATA ENTRY</option>
      <option value="EVENT ORGANIZATION"> EVENT ORGANIZATION</option>
  </select>
  </div>
  </div>
		

	<div class="well" style="margin-top: 5px">
		<center>
			<h3>posted advertisement</h3>
		</center>
	</div>
	
	<div id="aj">
	<p style="margin-top: 80px">
		<c:forEach var="entry" items="${it}">
			<!-- Key: <c:out value="${entry.key}" />
          Value: <c:out value="${entry.value}" />-->
			<div class="well well-lg">
				<c:set var="hm1" value="${entry.value}" />
				<c:forEach var="entry1" items="${hm1}">
					<c:out value="${entry1.key}" />:&nbsp; &nbsp;&nbsp;<c:out value="${entry1.value}" />
					<br />
				</c:forEach>
			</div>
		</c:forEach>
	</p>
	</div>

</body>
</html>