package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.customer.entity.Customer;
import com.customer.service.CustService;

@Controller
public class CustController {

	@Autowired
	private CustService custService;
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("list", custService.getAllCustomer());
		return "home";
	}
	@GetMapping("/registration")
	public String registration(Model m) {
		m.addAttribute("customer", new Customer());
		return "registration";
	}
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		custService.save(customer);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String updateCustomer(@PathVariable(value="id") int id,Model m) {
		Customer customer=custService.getCustomerById(id);
		m.addAttribute("customer", customer);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(value="id") int id) {
		custService.deleteCustomerById(id);
		return "redirect:/";
	}
}
