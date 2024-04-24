package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer>{

}
