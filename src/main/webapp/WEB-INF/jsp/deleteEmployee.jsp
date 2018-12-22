<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="deleteEmployee">
	<c:forEach var="listValue" items="${employee}">
		<li>${listValue}</li>
		</c:forEach>
	
	
		<form:form action="${contextPath}/deleteEmployee" method="post"
			modelAttribute="emp">
			
			<p>
				<label>Enter Employee Name</label>
				<form:input path="ename" />
			</p>
            
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
