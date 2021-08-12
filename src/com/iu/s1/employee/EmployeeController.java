package com.iu.s1.employee;

import com.iu.s1.location.LocationDTO;

public class EmployeeController {
		
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		
	}
	
	
	public void start() {
		
		//locationView.view(ar);
	
	
		
		Emp_DepartDTO emp_DepartDTO = employeeDAO.getJoin(101); 
		employeeView.view(employeeDAO);
		
		
	}
	
	
	
	
}
