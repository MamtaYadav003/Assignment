<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<a href="${pageContext.request.contextPath}/welcome">Home</a> | &nbsp;

	   <a href="${pageContext.request.contextPath}/addNewEmployee">Add New Employee</a> | &nbsp;
        <a href="${pageContext.request.contextPath}/deleteEmployee">Delete Employee </a>| &nbsp;
           <a href="${pageContext.request.contextPath}/getEmployee">Show Employee</a> | &nbsp;  
         
         <u><h6 style="color: red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h6></u>| &nbsp; 

    <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
    </form>

</div>