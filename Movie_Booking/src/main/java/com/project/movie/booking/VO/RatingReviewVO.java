package com.project.movie.booking.VO;

public class RatingReviewVO {

	private int booking_id;
	private String movie;
	private int rating;
	private String review;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public RatingReviewVO(int booking_id, String movie, int rating, String review) {
		super();
		this.booking_id = booking_id;
		this.movie = movie;
		this.rating = rating;
		this.review = review;
	}
	public RatingReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
