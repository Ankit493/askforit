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
				action="postadv1">
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
					<input name="location" type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">SEARCH</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="LogoutClass">LOGOUT</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="panel panel-info col-lg-10"
		style="margin-left: 100px; margin-top: 65px">
		<div class="panel-heading">
			<center>
				<h3 class="panel-title" style="font-size: medium;">Profile</h3>
			</center>
		</div>
		<div class="panel-body">
			<%!String fname, lname, addr, email, pwd, contact1, contact2, city, country;%>
			<%
				fname = (String) session.getAttribute("fname");
				lname = (String) session.getAttribute("lname");
				addr = (String) session.getAttribute("addr");
				email = (String) session.getAttribute("savedemail");
				city = (String) session.getAttribute("city");
				country = (String) session.getAttribute("country");
				pwd = (String) session.getAttribute("pwd");
				contact1 = (String) session.getAttribute("cont1");
				contact2 = (String) session.getAttribute("cont2");
			%>

			<table class="table table-striped table-hover"
				style="font-size: medium;">

				<tbody>
					<tr>
						<td>First Name</td>
						<td><%=fname%></td>

					</tr>
					<tr>
						<td>Last Name</td>
						<td><%=lname%></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><%=addr + ", " + city + ", " + country%></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><%=email%></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><%=pwd%></td>
					</tr>
					<tr>
						<td>Contact 1</td>
						<td><%=contact1%></td>
					</tr>
					<tr>
						<td>Contact 2</td>
						<td><%=contact2%></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<!--<c:set var="mapOfMaps" value="${HashMapStoredInSession}" />


	<c:forEach items="${mapOfMaps}" var="map">
		<c:set var="maps" value="${map.value}" />
		<c:forEach var="val" items="${maps}">
			<div class="well well-lg">${var.value}</div>
		</c:forEach>
	</c:forEach>-->

	<div class="well" style="margin-top: 500px">
		<center>
			<h3>My Ads</h3>
		</center>
	</div>
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

</body>
</html>