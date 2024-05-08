package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CourseDao;
import it.corso.dto.CategoryShowDto;
import it.corso.dto.CourseInsertDto;
import it.corso.dto.CourseShowDto;
import it.corso.model.Category;
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

	@Override
	public CourseShowDto findById(int id) {

		Optional<Course> course = courseDao.findById(id);

		return course.isPresent() ? mapper.map(course, CourseShowDto.class) : null;

	}

	@Override
	public void insert(CourseInsertDto courseInsertDto) {

		courseDao.save(mapper.map(courseInsertDto, Course.class));

	}

}
