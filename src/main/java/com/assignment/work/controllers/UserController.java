package com.assignment.work.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.assignment.work.model.Users;
import com.assignment.work.service.UserService;


@Controller
public class UserController {

	
	@Autowired
	UserService userService;

		
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	@RequestMapping("/")
	public ModelAndView firstPage1() {
		return new ModelAndView("welcome");
	}
	 
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public ModelAndView show() {
			return new ModelAndView("addUser", "usr", new Users());
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("usr") Users user) {

		userService.insertUser(user);
		List<Users> usr = userService.getAllUser();
		ModelAndView model = new ModelAndView("getUser");
		model.addObject("user", usr);
		return model;
	}

	@RequestMapping("/getUser")
	public ModelAndView getUser() {
		List<Users> user = userService.getAllUser();
		ModelAndView model = new ModelAndView("getUser");
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value= "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteStudent(@PathVariable String id) {
		userService.deleteById(id);
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value= "/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent1(@PathVariable String id) {
		userService.deleteById(id);
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
