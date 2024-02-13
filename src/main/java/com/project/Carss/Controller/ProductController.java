package com.project.Carss.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jayway.jsonpath.internal.Path;
import com.project.Carss.Dto.AddProductDto;
import com.project.Carss.Services.productServices;
import com.project.Carss.entities.Product;



@Controller
public class ProductController {
	
	@Autowired
	private productServices productservices;
	
	
	@GetMapping("/products")
	public String product(Model model) {
		model.addAttribute("productform", new Product());
		return "product";
		
	}
	
	@PostMapping("/addproduct")
	public String Add(@ModelAttribute AddProductDto addProductDto, Model model, @RequestParam("file") MultipartFile file) {
		
			model.addAttribute("productform", new Product());
			model.addAttribute("message","regestered");
			this.productservices.Add(addProductDto, file);
			return "redirect:/products";
			
		
	}
	
	@GetMapping("/shop")
	public ModelAndView getAll() {
		ModelAndView modelAndView= new ModelAndView("shop");
		modelAndView.addObject("allProducts",this.productservices.getAllprod());
		return modelAndView;
	}
	
	
}
