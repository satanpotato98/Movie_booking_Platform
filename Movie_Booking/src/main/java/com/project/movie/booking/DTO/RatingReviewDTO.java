package com.project.movie.booking.DTO;

public class RatingReviewDTO {

	private int rating;
	private String review;
	
	public RatingReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RatingReviewDTO( int rating, String review) {
		super();
		this.rating = rating;
		this.review = review;
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
	
}
