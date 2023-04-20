package com.project.movie.booking.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.booking.DTO.BookingDTO;
import com.project.movie.booking.DTO.CustomerDTO;
import com.project.movie.booking.DTO.RatingReviewDTO;
import com.project.movie.booking.VO.BookingVO;
import com.project.movie.booking.VO.RatingReviewVO;
import com.project.movie.booking.entity.Booking;
import com.project.movie.booking.exception.BookingNotFoundException;
import com.project.movie.booking.exception.MovieNotWatchedException;
import com.project.movie.booking.exception.ShowNotFoundException;
import com.project.movie.booking.repository.BookingRepo;
import com.project.movie.booking.repository.ShowsRepo;
import com.project.movie.booking.service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	IBookingService booking_service;
	
	@Autowired
	BookingRepo booking_repo;
	
	@Autowired
	ShowsRepo show_repo;
	
	@PostMapping("/add")
	public BookingVO book(@RequestBody BookingDTO dto) throws ShowNotFoundException {
		return booking_service.addBooking(dto);
		} 
	
	@DeleteMapping("/cancel/{booking_id}")
	public ResponseEntity<String> cancelBooking(@PathVariable int booking_id) throws BookingNotFoundException{
		if(booking_repo.findById(booking_id).orElse(null).getShow_id().getShow_date().isAfter(LocalDateTime.now()))
		{
		 booking_service.DeleteBookingbyId(booking_id);
		}
		else {
			throw new BookingNotFoundException();
		}
		return new ResponseEntity<String>("booking deleted",HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public BookingVO getBookingById(@PathVariable int id) {
		return booking_service.findBookingbyId(id);
	}
	
	@GetMapping("/get/customer/{id}")
	public Set<BookingVO> getCustomerBookings(@PathVariable int id){
		return booking_service.findCustomerBookings(id);
	}
	
	@GetMapping("/get/customer/{id}/watched")
	public Set<BookingVO> getCustomeMoviesWatched(@PathVariable int id){
		return booking_service.findCustomerMoviesWatched(id);
	}
	@GetMapping("/get/customer/{id}/canceled")
	public Set<BookingVO> getCustomeMoviesCanceled(@PathVariable int id){
		return booking_service.findCustomerMoviescanceled(id);
	}
	
	@PutMapping("/{booking_id}/add/review")
	public RatingReviewVO addReview(@RequestBody RatingReviewDTO dto, @PathVariable int booking_id) throws MovieNotWatchedException {
	
		return booking_service.setRatingReview(dto,booking_id);
	}
		

}
