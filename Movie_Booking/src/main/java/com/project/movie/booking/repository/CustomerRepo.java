package com.project.movie.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.movie.booking.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>  {

}
