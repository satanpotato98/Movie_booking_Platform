package com.project.movie.booking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.project.movie.booking.DTO.BookingDTO;
import com.project.movie.booking.DTO.RatingReviewDTO;
import com.project.movie.booking.VO.BookingVO;
import com.project.movie.booking.VO.RatingReviewVO;
import com.project.movie.booking.entity.Booking;
import com.project.movie.booking.exception.BookingNotFoundException;
import com.project.movie.booking.exception.MovieNotWatchedException;
import com.project.movie.booking.exception.ShowNotFoundException;

public interface IBookingService {
	public BookingVO addBooking(BookingDTO dto) throws ShowNotFoundException;//user
	public void DeleteBookingbyId(int id);//admin||user
	public BookingVO findBookingbyId(int booking_id);//admin||user
	public Set<BookingVO> findCustomerBookings(int customer_id);//repo //user||admin
	public Set<BookingVO> findCustomerMoviesWatched(int customer_id);
	public Set<BookingVO> findCustomerMoviescanceled(int customer_id);
	public RatingReviewVO setRatingReview(RatingReviewDTO dto, int booking_id) throws MovieNotWatchedException ;
}
