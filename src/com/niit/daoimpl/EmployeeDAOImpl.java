package com.niit.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.niit.dao.EmployeeDAO;
import com.niit.entity.Employee;
import com.niit.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	private static EmployeeDAO employeeDAO = null;
	Connection con = null;
	private EmployeeDAOImpl(){
		con = DBUtil.getConnection();
	}
	//Singleton Pattern
	public static EmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null){
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
	
	
	
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Employee employee) {
		
		String insertQuery = "INSERT INTO employee"
				+ "('first_name','last_name','salary',working)"
				+ "VALUES(?,?,?,?)";
		try(
			PreparedStatement pstmt = con.prepareStatement(insertQuery);	
			){
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setDouble(3, employee.getSalary());
			pstmt.setBoolean(3, employee.isWorking());
			pstmt.execute();
			return true;
			
		}catch(SQLException e){
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
