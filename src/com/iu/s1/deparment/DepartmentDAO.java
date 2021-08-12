package com.iu.s1.deparment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.util.DBConnect;

public class DepartmentDAO {
	
	private DBConnect dbConnect;
	
	public	DepartmentDAO() {
		dbConnect = new DBConnect();
	}
	
	
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {
		Connection con = null;
		PreparedStatement st = null; 
		ResultSet rs = null;
		Depart_EmpDTO dto = null;


		try {
			con=dbConnect.getConnect();
			
			String sql="SELECT E.FIRST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME\r\n"
					+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D\r\n"
					+ "USING (DEPARTMENT_ID)\r\n"
					+ "WHERE DEPARTMENT_ID = ?;";
			
			st=con.prepareStatement(sql);
			st.setInt(1, departmentDTO.getDepartment_id());
			rs=st.executeQuery();
			
			dto= new Depart_EmpDTO();
			dto.setAr(new ArrayList<EmployeeDTO>());
			
			
			while(rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				
				eDto.setLast_name(rs.getString("Last_name"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getDate("hire_date"));
				dto.getAr().add(eDto);
				dto.setDepartment_name(rs.getString("department_name"));
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dto;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
