package it.corso.service;

import java.util.List;

import it.corso.dto.CourseInsertDto;
import it.corso.dto.CourseShowDto;

public interface CourseService {
	
	List<CourseShowDto> getCourses();
	
	CourseShowDto findById(int id);
	
	void insert(CourseInsertDto courseInsertDto);
	
	void delete(int id);

}
