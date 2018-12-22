<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="${pageContext.request.contextPath}/addNewEmployee" method="post"
modelAttribute="emp">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="eid" />
			</p>
			<p>
				<label>Enter Employee Name</label>
				<form:input path="ename" />
			</p>
            <p>
				<label>Enter Email ID</label>
                <form:input path="emailid" />
			</p>
            <p>
				<label>Enter Mobile No</label>
				<form:input path="emobile" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
