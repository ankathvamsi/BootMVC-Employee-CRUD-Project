package com.ankathvamsi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankathvamsi.service.IEmployeeService;
import com.ankathvamsi.vo.EmployeeVO;

import jakarta.servlet.http.HttpSession;

//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeOperationsController {
	
	final IEmployeeService service;
	EmployeeOperationsController(IEmployeeService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";//view name
	}
	
	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		List<EmployeeVO> listOfVO=service.showAllEmployees();
		map.put("listVO", listOfVO);
		return "show_report";
	}
	
	//This one is just to show the form pages
	@GetMapping("/add")
	public String showRegistrationPage(@ModelAttribute("dvo") EmployeeVO vo) {
		return "register_employee";
	}
	//this method actually registers the employee record 
	@PostMapping("/add")
	public String registerEmployee(@ModelAttribute("dvo") EmployeeVO vo,HttpSession ses) {
		String msg=service.registerEmployee(vo);
		ses.setAttribute("resultMsgOfAdd", msg);
		return "redirect:report";
	}
	
	//This one is Important
	@GetMapping("/edit")
	public String showEditFormPage(@ModelAttribute("dvo") EmployeeVO vo,@RequestParam("id") int id) {
		EmployeeVO voObjFromDb=service.showEmployeeById(id);
		BeanUtils.copyProperties(voObjFromDb, vo);
		return "edit_employee";
	}
	
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("dvo") EmployeeVO vo,HttpSession ses) {
		String msg=service.updateEmployee(vo);
		ses.setAttribute("resultMsg", msg);
		
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id,Map<String, Object> map) {
		String msg=service.deleteEmployeeById(id);
		map.put("resultMsg", msg);
		return "forward:report";
	}
	
	
}
