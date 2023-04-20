package com.project.movie.booking.VO;

import java.time.LocalTime;

public class TheatreVO {

	private int theatre_id;
	private String theatre_name;
	private String location;
	private LocalTime show_time;
	
	public TheatreVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}

	public String getTheatre_name() {
		return theatre_name;
	}

	public void setTheatre_name(String theatre_name) {
		this.theatre_name = theatre_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public TheatreVO(int theatre_id, String theatre_name, String location,LocalTime show_time ) {
		super();
		this.theatre_id = theatre_id;
		this.theatre_name = theatre_name;
		this.location = location;
		this.show_time=show_time;	
	}

	public LocalTime getShow_time() {
		return show_time;
	}

	public void setShow_time(LocalTime show_time) {
		this.show_time = show_time;
	}
	
}
