package com.niit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.EmployeeDAO;
import com.niit.daoimpl.EmployeeDAOImpl;
import com.niit.entity.Employee;

@WebServlet(urlPatterns = { "/EmployeeController", "/EmployeeController.do" })
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAO employeeDAO = EmployeeDAOImpl.getEmployeeDAO();
	
	private static final String LIST_VIEW = "/listEmployee.jsp";
	private static final String FORM_VIEW = "/formEmployee.jsp";
	public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get the action
		String action = request.getParameter("action");
		String forward = "";
		if(action.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("msg", "User with "+id+" is deleted");
			employeeDAO.delete(id);
			request.setAttribute("employees", employeeDAO.list());
			forward = LIST_VIEW;
		}else if(action.equals("insert")){
			forward = FORM_VIEW;
		}else if(action.equals("edit")){
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = employeeDAO.get(id);
			//employeeDAO.update(employee);
			request.setAttribute("employee", employee);
			forward = FORM_VIEW;
		}
		else{
			request.setAttribute("employees", employeeDAO.list());
			forward = LIST_VIEW;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Employee Saving Code Comes here
		//get the values from the form
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		boolean working = Boolean.parseBoolean(request.getParameter("working"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		//New Employee Object
		//set the values from the form to the object
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setWorking(working);
		
		System.out.println(employee);
		if(id == 0){
			employeeDAO.add(employee);
		}else{
			employeeDAO.update(employee);
		}
		
		response.sendRedirect("index.jsp");
		
		//doGet(request, response);
	}
}
