<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.niit.entity.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<%
		//fetching all the records
		List<Employee> employees = (List<Employee>)request.getAttribute("employees");
		String deletedId =  (String) request.getAttribute("deletedId");
		if(deletedId != null){
			out.println(deletedId);
		}
	%>


	<table border="1" width="80%" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Salary</th>
				<th>Working</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Employee employee : employees){
			%>
				<tr>
					<td><%=employee.getId() %></td>
					<td><%=employee.getFirstName()%></td>
					<td><%=employee.getLastName()%></td>
					<td><%=employee.getSalary()%></td>
					<td><%=employee.isWorking() %></td>
					<td><a href="EmployeeController.do?action=edit&id=<%=employee.getId()%>">Edit</a></td>
					<td><a href="EmployeeController.do?action=delete&id=<%=employee.getId()%>">Delete</a></td>
				</tr>
			
			<%
				} %>
		</tbody>
		<tfoot>
			<tr>
				<td colspan ="7" align="center"><a href = "EmployeeController.do?action=insert">Add New Employee</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>