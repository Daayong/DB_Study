package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.s1.deparment.DepartmentDTO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.util.DBConnect;

public class EmployeeDAO {

	private DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
		
	}
	
		
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		Emp_DepartDTO emp_DepartDTO = null;
		try {
			con=dbConnect.getConnect();
			
			String sql="SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME\r\n"
					+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D\r\n"
					+ "ON E.DEPARTMENT_ID = D.DEPARTMENT_ID\r\n"
					+ "WHERE E.EMPLOYEE_ID=?";
			
			st=con.prepareStatement(sql);
			st.setInt(1, employeeDTO.getEmployee_id());
			rs=st.executeQuery();
			
			if(rs.next()) {
				emp_DepartDTO= new Emp_DepartDTO();
				emp_DepartDTO.setDepartmentDTO(new DepartmentDTO());
				
				emp_DepartDTO.setLast_name(rs.getString("last_name"));
				emp_DepartDTO.setHire_date(rs.getDate("hire_date"));
				emp_DepartDTO.setSalary(rs.getInt("salary"));
				emp_DepartDTO.getDepartmentDTO().setDepartment_name(rs.getString("department_name"));
				
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
		return emp_DepartDTO;
		
	}
	
	
	
	
	
	
	//1.전체 사원출력 
	public ArrayList<EmployeeDTO> getList() {
		Connection con = null; 
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		EmployeeDTO employeeDTO = null;
		try {
			con=dbConnect.getConnect();
			
			String sql = "SELECT * FROM EMPLOYEES";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				employeeDTO = new EmployeeDTO();   //DB에서 꺼낸 데이터를 DTO에 담을거야! 
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getDate("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
				employeeDTO.setManager_id(rs.getInt("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));
				ar.add(employeeDTO);
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
		return ar;
		
	}
	//2. 사원번호 입력해서 한사원의 정보 출력 
	//3. Last_name을 검색해서 정보 출력 
	//4. First_name 검색해서 정보 출력 
	//5. 전체 평균 급여의 정보를 출력 
	//6. 부서별 평균 급여의 정보를 출력 
	
	
	
	
	
	
	
}
