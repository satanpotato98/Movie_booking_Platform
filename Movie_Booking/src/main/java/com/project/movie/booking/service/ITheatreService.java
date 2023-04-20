package com.project.movie.booking.service;

import java.util.List;
import java.util.Set;

import com.project.movie.booking.DTO.TheatreDTO;
import com.project.movie.booking.VO.TheatreVO;
import com.project.movie.booking.entity.Theatre;


public interface ITheatreService {

	public Theatre addTheatre(TheatreDTO dto);//admin
	public void deleteTheatreById(int Theatre_id);//admin
	public List<Theatre> findByLocation(String location);//repo//admin||user
	public Set<TheatreVO> findByMovie(String movie);//repo //admin||user
	public List<Theatre> findAll();
	//ameneties??
}
