package com.project.movie.booking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.booking.DTO.BookingDTO;
import com.project.movie.booking.DTO.RatingReviewDTO;
import com.project.movie.booking.VO.BookingVO;
import com.project.movie.booking.VO.RatingReviewVO;
import com.project.movie.booking.entity.Booking;
import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.exception.BookingNotFoundException;
import com.project.movie.booking.exception.MovieNotWatchedException;
import com.project.movie.booking.exception.ShowNotFoundException;
import com.project.movie.booking.repository.BookingRepo;
import com.project.movie.booking.repository.CustomerRepo;
import com.project.movie.booking.repository.MovieRepo;
import com.project.movie.booking.repository.ShowsRepo;

@Service
public class BookingServiceImp implements IBookingService {
	
	@Autowired
	BookingRepo booking_repo;
	
	@Autowired
	CustomerRepo customer_repo;
	
	@Autowired
	ShowsRepo shows_repo;
	
	@Autowired
	MovieRepo movie_repo;
	

	@Override
	public BookingVO addBooking(BookingDTO dto) throws ShowNotFoundException {
		// TODO Auto-generated method stub
		if(shows_repo.findById(dto.getShow_id()).orElse(null).getShow_date().isBefore(LocalDateTime.now()))
		{
			throw new ShowNotFoundException();
		}
			Booking booking=new Booking();
			booking.setBooking_date(LocalDate.now());
			booking.setCustomer_id(customer_repo.findById(dto.getCustomer_id()).orElse(null));
			booking.setShow_id(shows_repo.findById(dto.getShow_id()).orElse(null));
			booking.setPayment_method(dto.getPayment_method());
			booking.setSeats(dto.getSeats());
			booking.setTotal_amount(dto.getTotal_amount());
			booking.getCustomer_id().addBooking(booking);
			booking.setCanceled(false);
			booking=booking_repo.save(booking);
			
			/*
			 * Movie
			 * movie=movie_repo.findById(shows_repo.findById(dto.getShow_id()).orElse(null).
			 * getMovie().getMovie_id()).orElse(null);
			 * System.out.println(movie_repo.findById(shows_repo.findById(dto.getShow_id()).
			 * orElse(null).getMovie().getMovie_id()).orElse(null).getMovie_title());
			 * booking.getCustomer_id().addMovieswatched(movie);
			 * booking=booking_repo.save(booking); movie_repo.save(movie);
			 * customer_repo.save(booking.getCustomer_id());
			 */
			
			/*
			 * Customer cus=customer_repo.findById(dto.getCustomer_id()).orElse(null);
			 * cus.addBooking(booking); Movie
			 * movie=movie_repo.findById(shows_repo.findById(dto.getShow_id()).orElse(null).
			 * getMovie().getMovie_id()).orElse(null); cus.addMovieswatched(movie);
			 * cus.addMovieswatched(movie); customer_repo.save(cus);
			 */
			 
			
			BookingVO vo=new BookingVO();
			vo.setBooking_id(booking.getBooking_id());
			vo.setBooking_date(booking.getBooking_date());
			vo.setCustomer_id(dto.getCustomer_id());
			vo.setCustomer_name(customer_repo.findById(dto.getCustomer_id()).orElse(null).getCustomer_name());
			vo.setMovie_title(booking.getShow_id().getMovie().getMovie_title());
			vo.setPayment_method(dto.getPayment_method());
			vo.setShow_id(dto.getShow_id());
			vo.setSeats(dto.getSeats());
			vo.setTotal_amount(dto.getTotal_amount());
			vo.setStatus("Active");
			vo.setShow_date(booking.getShow_id().getShow_date());
			
			
			return vo;
	}

	@Override
	public void DeleteBookingbyId(int id) {
		// TODO Auto-generated method stub
		
		Booking booking=booking_repo.findById(id).orElse(null);
		if(booking.getShow_id().getShow_date().isBefore(LocalDateTime.now()))
		{
		booking.setCanceled(true);
		}
		
		booking_repo.save(booking);
		

	}

	@Override
	public Set<BookingVO> findCustomerBookings(int customer_id) {
		// TODO Auto-generated method stub
		Customer cus=customer_repo.findById(customer_id).orElse(null);
		Set<Booking> bookings=cus.getBooking();
		Set<BookingVO> customer_bookings=new HashSet<>();
		for (Booking booking : bookings) {
			BookingVO vo=new BookingVO();
			vo.setBooking_date(booking.getBooking_date());
			vo.setBooking_id(booking.getBooking_id());
			vo.setCustomer_id(customer_id);
			vo.setCustomer_name(booking.getCustomer_id().getCustomer_name());
			vo.setMovie_title(booking.getShow_id().getMovie().getMovie_title());
			vo.setPayment_method(booking.getPayment_method());
			vo.setSeats(booking.getSeats());
			vo.setShow_id(booking.getShow_id().getShow_id());
			vo.setTotal_amount(booking.getTotal_amount());
			if(booking.isCanceled()) {
				vo.setStatus("canceled");
			}
			else {
				vo.setStatus("Active");
			}
			customer_bookings.add(vo);
		}
		
		
		return customer_bookings;
	}

	@Override
	public BookingVO findBookingbyId(int booking_id) {
		// TODO Auto-generated method stub
		Booking booking=booking_repo.findById(booking_id).orElse(null);
		BookingVO vo=new BookingVO();
		vo.setBooking_date(booking.getBooking_date());
		vo.setBooking_id(booking_id);
		vo.setCustomer_id(booking.getCustomer_id().getCustomer_id());
		vo.setCustomer_name(booking.getCustomer_id().getCustomer_name());
		vo.setMovie_title(booking.getShow_id().getMovie().getMovie_title());
		vo.setSeats(booking.getSeats());
		vo.setPayment_method(booking.getPayment_method());
		vo.setShow_id(booking.getShow_id().getShow_id());
		vo.setTotal_amount(booking.getTotal_amount());
		if(booking.isCanceled()==true) {
			vo.setStatus("canceled");

		}
		else {
			vo.setStatus("completed");
		}
		
		return vo;
		
	}

	@Override
	public Set<BookingVO> findCustomerMoviesWatched(int customer_id) {
		// TODO Auto-generated method stub
		Set<Booking> customer_booking=customer_repo.findById(customer_id).orElse(null).getBooking();
		Set<BookingVO> movies_watched =new HashSet<>();
		for (Booking booking : customer_booking) {
			if(!booking.isCanceled())
			{
				BookingVO vo=new BookingVO();
				vo.setBooking_date(booking.getBooking_date());
				vo.setBooking_id(booking.getBooking_id());
				vo.setCustomer_id(customer_id);
				vo.setCustomer_name(booking.getCustomer_id().getCustomer_name());
				vo.setMovie_title(booking.getShow_id().getMovie().getMovie_title());
				vo.setPayment_method(booking.getPayment_method());
				vo.setSeats(booking.getSeats());
				vo.setShow_id(booking.getShow_id().getShow_id());
				vo.setTotal_amount(booking.getTotal_amount());
				vo.setStatus("Active");
				movies_watched.add(vo);
			}
		}
		return movies_watched;
	}
	
	@Override
	public Set<BookingVO> findCustomerMoviescanceled(int customer_id) {
		// TODO Auto-generated method stub
		Set<Booking> customer_booking=customer_repo.findById(customer_id).orElse(null).getBooking();
		Set<BookingVO> movies_watched =new HashSet<>();
		for (Booking booking : customer_booking) {
			if(booking.isCanceled()) {
				BookingVO vo=new BookingVO();
				vo.setBooking_date(booking.getBooking_date());
				vo.setBooking_id(booking.getBooking_id());
				vo.setCustomer_id(customer_id);
				vo.setCustomer_name(booking.getCustomer_id().getCustomer_name());
				vo.setMovie_title(booking.getShow_id().getMovie().getMovie_title());
				vo.setPayment_method(booking.getPayment_method());
				vo.setSeats(booking.getSeats());
				vo.setShow_id(booking.getShow_id().getShow_id());
				vo.setTotal_amount(booking.getTotal_amount());
				vo.setStatus("canceled");
				movies_watched.add(vo);
			}
		}
		return movies_watched;
	}

	@Override
	public RatingReviewVO setRatingReview(RatingReviewDTO dto,int booking_id) throws MovieNotWatchedException {
		// TODO Auto-generated method stub
		
		Booking booking=booking_repo.findById(booking_id).orElse(null);
		if(booking.getShow_id().getShow_date().isBefore(LocalDateTime.now()))
		{
			booking.setRating(dto.getRating());
			booking.setReview(dto.getReview());
			booking_repo.save(booking);
			RatingReviewVO vo=new RatingReviewVO();
			vo.setBooking_id(booking.getBooking_id());
			vo.setMovie(booking.getShow_id().getMovie().getMovie_title());
			vo.setRating(dto.getRating());
			vo.setReview(dto.getReview());
			Set<Integer> sameMovieBookings=new HashSet<>();
			sameMovieBookings =booking_repo.findBymovie(booking.getShow_id().getMovie().getMovie_id());
			
			//-----------entity Movie Rating Setting Mechanism----------------
			
			
			int rating_sum=0,n=0;
			for (Integer x : sameMovieBookings) {
				Booking book=booking_repo.findById(x).orElse(null);
				
				rating_sum=rating_sum+book.getRating();
				n++;
			}
			int rating_avg=0;
			if(n!=0) {
				rating_avg=rating_sum/n;
			}
			Movie movie=movie_repo.findById(booking.getShow_id().getMovie().getMovie_id()).orElse(null);
			movie.setRating(rating_avg);
			movie_repo.save(movie);
			//-----------------------------------------------------------
			
			
			return vo;
		}
		else {
			throw new MovieNotWatchedException();
		}
		
	}
	

}
