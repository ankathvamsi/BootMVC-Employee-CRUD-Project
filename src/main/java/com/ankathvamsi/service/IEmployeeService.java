package com.ankathvamsi.service;

import java.util.List;

//import com.ankathvamsi.entity.EmployeeEntity;
import com.ankathvamsi.vo.EmployeeVO;

public interface IEmployeeService {
	public String registerEmployee(EmployeeVO vo);
	public EmployeeVO showEmployeeById(int id);
	public List<EmployeeVO> showAllEmployees();
	public String deleteEmployeeById(int id);
	public String updateEmployee(EmployeeVO vo);

}
