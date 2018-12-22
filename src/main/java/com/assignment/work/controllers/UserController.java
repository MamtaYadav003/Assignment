package com.assignment.work.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.assignment.work.model.Employee;
import com.assignment.work.service.EmployeeService;


@Controller
public class UserController {

	
	@Autowired
	EmployeeService employeeService;

		
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	@RequestMapping("/")
	public ModelAndView firstPage1() {
		return new ModelAndView("welcome");
	}
	@RequestMapping("/403")
	public ModelAndView Error() {
		return new ModelAndView("403");
	}
	 
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
			return new ModelAndView("addEmployee", "emp", new Employee());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee empl) {
        System.out.println("in add new emp");
		employeeService.insertEmployee(empl);
		List<Employee> emplo = employeeService.getAllEmployee();
		ModelAndView model = new ModelAndView("getEmployee");
		model.addObject("employee", emplo);
		return model;
	}

	@RequestMapping("/getEmployee")
	public ModelAndView getEmployee() {
		List<Employee> emplo = employeeService.getAllEmployee();
		ModelAndView model = new ModelAndView("getEmployee");
		model.addObject("employee", emplo);
		return model;
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployee() {
		employeeService.deleteEmployee();
		return new ModelAndView("welcome");
	}
	
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}
