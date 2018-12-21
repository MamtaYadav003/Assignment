<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New User</h3>

	<div id="addUser">
		<form:form action="/addNewUser" method="post"
			modelAttribute="usr">
			<p>
				<label>Enter User Id</label>
				<form:input path="Id" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="username" />
			</p>
            <p>
				<label>Enter Password</label>
                <form:password path="password" />
			</p>
            <p>
				<label>Enter Enabled</label>
				<form:radiobutton path="enabled" value="true"/>True 
                <form:radiobutton path="enabled" value="false"/>False
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
