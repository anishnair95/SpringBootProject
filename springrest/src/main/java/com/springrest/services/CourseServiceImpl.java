package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.model.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
//	List<Course>list;
	public CourseServiceImpl() {
		
		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
       return courseDao.findAll();
	}

	 @Override
	public Optional<Course> getCourse(long courseId) {
		 

		 return courseDao.findById(courseId);
	 }
	 
	 @Override
		public Course addCourse(Course course) {
		 
		 return courseDao.save(course);
	 }
	 
	 @Override
		public Course updateCourse(Course course) {
		 
		 return courseDao.save(course);
	 }

	 @Override
	 public void deleteCourse(long courseId) {

		 Course course = courseDao.getOne(courseId);
		 courseDao.delete(course);
	 }
}
