package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CourseDao;
import it.corso.dto.CourseShowDto;
import it.corso.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<CourseShowDto> getCourses() {

		List<Course> courseList = courseDao.findAll();

		List<CourseShowDto> courseListDto = new ArrayList<>();

		courseList.forEach(c -> courseListDto.add(mapper.map(c, CourseShowDto.class)));

		return courseListDto;

	}

}
