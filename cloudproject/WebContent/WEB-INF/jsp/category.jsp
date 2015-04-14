<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>hello return from ajax123</h3>


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
	
<h3>finish from ajax123</h3>
</body>
</html>