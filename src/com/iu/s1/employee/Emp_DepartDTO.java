package com.iu.s1.employee;

import com.iu.s1.deparment.DepartmentDTO;

public class Emp_DepartDTO extends EmployeeDTO {

	//사원은 부서를 가지고있다
	private DepartmentDTO departmentDTO;

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	
	
	
	
	
	
}
