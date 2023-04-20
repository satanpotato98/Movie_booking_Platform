package com.project.movie.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<String> bookingNotFound() {
		return  new ResponseEntity<String>("Booking Not Found",HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(MovieNotWatchedException.class)
	public ResponseEntity<String> movieNotWatched(){
		return  new ResponseEntity<String>("Movie not watched yet",HttpStatus.EXPECTATION_FAILED);
	}
	
	
	@ExceptionHandler(PastDateException.class)
	public ResponseEntity<String> pastDateException(){
		return  new ResponseEntity<String>("enter correct date",HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(ShowNotFoundException.class)
	public ResponseEntity<String> ShowNotFound(){
		return  new ResponseEntity<String>("Show Not Found",HttpStatus.EXPECTATION_FAILED);
	}
}