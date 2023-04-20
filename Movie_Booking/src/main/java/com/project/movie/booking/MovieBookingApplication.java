package com.project.movie.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.repository.CustomerRepo;
import com.project.movie.booking.repository.MovieRepo;

@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

/*	@Autowired
	MovieRepo movierepo;
	
	@Autowired
	CustomerRepo customerrepo;
	
	@Bean
	public CommandLineRunner onetomany() {
		return args->{
			Movie movie1=new Movie();
			movie1.setMovie_id(1);
			movie1.setDirector("rober");
			movie1.setDuration(100);
			movie1.setGenre("action");
			movie1.setMovie_title("batman");
			movie1.setRating(10);
			Movie movie2=new Movie();
			movie2.setMovie_id(2);
			movie2.setDirector("rober");
			movie2.setDuration(100);
			movie2.setGenre("action");
			movie2.setMovie_title("batman2");
			movie2.setRating(10);
			
			Customer customer=new Customer();
			customer.setCustomer_id(1);
			customer.setContact(78298);
			customer.setEmail("yolo@gmail.com");
			customer.setCustomer_name("raj");
			customer.addMoviewatched(movie1);
			customer.addMoviewatched(movie2);
			customerrepo.save(customer);
			Customer customer2=new Customer();
			customer2.setCustomer_id(2);
			customer2.setContact(78298);
			customer2.setEmail("yolo@gmail.com");
			customer2.setCustomer_name("shashwat");
			customer2.addMoviewatched(movie1);
			customer2.addMoviewatched(movie2);
			customerrepo.save(customer2);
			
			
			
		};
	}*/
}
