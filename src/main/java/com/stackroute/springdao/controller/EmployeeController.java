package com.stackroute.springdao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.springdao.dao.EmployeeDAOImpl;
import com.stackroute.springdao.dao.IEmployeeDAO;
import com.stackroute.springdao.model.Employee;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@GetMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("employees",employeeDAO.getAllEmployees());
		return modelAndView;
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
		
		
	
		boolean status = employeeDAO.saveEmployee(employee);
		modelMap.addAttribute("employees", employeeDAO.getAllEmployees());
		
		return "index";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empId") int empId) {
		employeeDAO.deleteEmployee(empId);
		return "redirect:/";
	}

}
