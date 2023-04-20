package com.project.movie.booking.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.booking.DTO.CustomerDTO;
import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customer_service;

	@PostMapping("/register")
	public Customer register_customer(@RequestBody CustomerDTO dto) {
		
		return customer_service.addCustomer(dto);
	}
	
	@GetMapping("/get/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customer_service.findCustomerById(id);
	}
	
}
