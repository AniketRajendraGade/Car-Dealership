package com.project.Carss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.Carss.Dto.AddUserDto;
import com.project.Carss.Services.UserServices;
import com.project.Carss.Services.productServices;
import com.project.Carss.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("userform",new User());
		return "index";
	}
	
	@PostMapping("/users")
	public String create(@ModelAttribute AddUserDto addUserDto, Model model) {
		model.addAttribute("userform", new User());
		this.userServices.create(addUserDto);
		return "index";
	}
	
	@GetMapping("/users/getall")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView("users");
		modelAndView.addObject("user", this.userServices.getAll());
		return modelAndView;
	}
	
	@GetMapping("/student/delete/{id}")
	public String delete(@PathVariable Integer id) {
		this.userServices.DeleteUser(id);
		return "redirect:/";
	}
	
	
}
