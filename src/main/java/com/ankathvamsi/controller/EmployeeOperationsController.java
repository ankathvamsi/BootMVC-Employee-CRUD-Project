package com.ankathvamsi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeOperationsController {

	@GetMapping("/test")
	public String testController() {
		return "It is Working!!!";
	}
}
