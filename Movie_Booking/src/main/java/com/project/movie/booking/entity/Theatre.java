package com.project.movie.booking.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int theatre_id;
	private String theatre_name;
	private String location;
	private int capacity;
	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("theatre")
	private Set<Shows> show=new HashSet<>();  
	public Theatre() {
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Set<Shows> getshow() {
		return show;
	}
	public void setshow(Set<Shows> show) {
		this.show = show;
	}
	public Theatre(int theatre_id, String theatre_name, String location, int capacity, Set<Shows> show) {
		super();
		this.theatre_id = theatre_id;
		this.theatre_name = theatre_name;
		this.location = location;
		this.capacity = capacity;
		this.show = show;
	}
	
	public void addShow(Shows show) {
		Set<Shows> shows=this.getshow();
		shows.add(show);
		
	}
}
