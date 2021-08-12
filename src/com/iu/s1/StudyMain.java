package com.iu.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.iu.s1.deparment.Depart_EmpDTO;
import com.iu.s1.deparment.DepartmentDAO;
import com.iu.s1.deparment.DepartmentDTO;
import com.iu.s1.employee.Emp_DepartDTO;
import com.iu.s1.employee.EmployeeController;
import com.iu.s1.employee.EmployeeDAO;
import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;

public class StudyMain {

	public static void main(String[] args) {
		
		//LocationController lc = new LocationController();
	//	lc.start();

	//	EmployeeDAO employeeDAO = new EmployeeDAO();
	//	EmployeeDTO employeeDTO = new EmployeeDTO();
	//	employeeDTO.setEmployee_id(101);
	//	Emp_DepartDTO emp_DepartDTO=employeeDAO.getJoin(employeeDTO);
		
	//	System.out.println(emp_DepartDTO.getLast_name());
	//	System.out.println(emp_DepartDTO.getHire_date());
	//	System.out.println(emp_DepartDTO.getSalary());
	//	System.out.println(emp_DepartDTO.getDepartmentDTO().getDepartment_name());
		
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(90);
		
		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
		System.out.println(dto.getDepartment_name());
		
		for(int i=0; i<dto.getAr().size(); i++) {
			System.out.println("----------------------------------");
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			System.out.println("----------------------------------");
		}
		
			
			
	}

}