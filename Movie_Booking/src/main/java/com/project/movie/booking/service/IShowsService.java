package com.project.movie.booking.service;

import java.util.List;

import com.project.movie.booking.DTO.ShowsDTO;
import com.project.movie.booking.VO.ShowsVO;
import com.project.movie.booking.entity.Shows;
import com.project.movie.booking.exception.PastDateException;

public interface IShowsService {
	
	public ShowsVO addShow(ShowsDTO dto) throws PastDateException;//admin
	public void deleteShowById(int id);//admin
	public void updateShow(ShowsDTO dto);//admin
	public List<Shows> getall();
	public List<Shows> getshowsByTheatreName(String theatre_name);//repo //mapping //admin||user

}
