package com.project.movie.booking.DTO;

import java.util.HashSet;
import java.util.Set;

import com.project.movie.booking.entity.Shows;


public class TheatreDTO {
	private int theatre_id;
	private String theatre_name;
	private String location;
	private int capacity;

	private Set<Shows> movie=new HashSet<>();
	public TheatreDTO(int theatre_id, String theatre_name, String location, int capacity) {
		super();
		this.theatre_id = theatre_id;
		this.theatre_name = theatre_name;
		this.location = location;
		this.capacity = capacity;
	}
	public TheatreDTO() {
		super();
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
