<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.niit.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body> 
	<%
 		Employee employee =(Employee) request.getAttribute("employee");
		if(employee == null){
			employee = new Employee();
			employee.setFirstName("");
			employee.setLastName("");
		}
	
 	%>
	<hr><h1 align="center">Employee Details</h1><hr>
	<form action = "EmployeeController.do" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label for="firstName">Enter First Name: </label></td>
					<td><input type="text" name="firstName"
						placeholder="First Name" value="<%=employee.getFirstName()%>">
						<input type="hidden" name="id" value="<%=employee.getId()%>"/>
						</td>
						
				</tr>

				<tr>
					<td><label for="lastName">Enter Last Name: </label></td>
					<td><input type="text" name="lastName" placeholder="Last Name"
						value="<%=employee.getLastName()%>"></td>
				</tr>

				<tr>
					<td><label for="salary">Enter Salary: </label></td>
					<td><input type="text" name="salary" placeholder="Salary"
						value="<%=employee.getSalary()%>"></td>
				</tr>
				<tr>
					<td><label for="working">Working: </label></td>
					<td><input type="checkbox" name="working" value="true"
						checked="<%=employee.isWorking()%>">Presently Working</td>
				</tr>
			</tbody>
		</table>
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
			</form>
			</body>
</html>