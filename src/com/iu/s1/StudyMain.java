package com.iu.s1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.deparment.Depart_EmpDTO;
import com.iu.s1.deparment.DepartmentDAO;
import com.iu.s1.deparment.DepartmentDTO;
import com.iu.s1.employee.Emp_DepartDTO;
import com.iu.s1.employee.EmployeeController;
import com.iu.s1.employee.EmployeeDAO;
import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.location.LocationView;

public class StudyMain {

	public static void main(String[] args) {
				
		LocationController lc = new LocationController();
		
		lc.start();
		
		
		
		/*
		locationDTO.setLocation_id(1);
		
		locationDTO=locationDAO.getOne(locationDTO);
		
		if(locationDTO != null) {
			System.out.println(locationDTO.getLocation_id());
			System.out.println(locationDTO.getStreet_address());
			System.out.println(locationDTO.getCity());
			
		}else {
			System.out.println("조회 실패 ");
		}
	*/	
		
		
		
		
		
	
	}

}