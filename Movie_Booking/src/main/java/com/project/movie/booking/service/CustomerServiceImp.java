package com.project.movie.booking.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.booking.DTO.CustomerDTO;
import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.repository.CustomerRepo;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	CustomerRepo customer_repo;

	
	@Override
	public Customer addCustomer(CustomerDTO dto) {
		Customer customer=new Customer();
		customer.setCustomer_name(dto.getCustomer_name());
		customer.setEmail(dto.getEmail());
		customer.setContact(dto.getContact());
		return customer_repo.save(customer);
	}
	
	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return customer_repo.findById(id).orElse(null);
	}




}
