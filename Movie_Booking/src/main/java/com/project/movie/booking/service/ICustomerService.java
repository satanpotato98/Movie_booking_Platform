package com.project.movie.booking.service;

import java.util.List;
import java.util.Set;

import com.project.movie.booking.DTO.CustomerDTO;
import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Movie;

public interface ICustomerService {

	public Customer addCustomer(CustomerDTO dto);//user
	public void deleteCustomerById(int id);//admin
	public Customer updateCustomer(Customer customer);//admin
	public Customer findCustomerById(int id);
	
}
